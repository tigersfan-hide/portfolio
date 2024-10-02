package com.example.portfolio.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.portfolio.form.SignupForm;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Customer;
import com.stripe.model.PaymentMethod;
import com.stripe.model.Subscription;
import com.stripe.model.checkout.Session;
import com.stripe.param.CustomerCreateParams;
import com.stripe.param.CustomerUpdateParams;
import com.stripe.param.PaymentMethodAttachParams;
import com.stripe.param.SubscriptionCancelParams;
import com.stripe.param.SubscriptionCreateParams;
import com.stripe.param.checkout.SessionCreateParams;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class StripeService {
	@Value("${stripe.api-key}")
    private String stripeApiKey;
	
	// 0.サブスクリプションIDをapplication.propertiesから取得
    @Value("${stripe.premium-plan-id}")
    private String premiumPlanId;
	
	public Customer createCustomer(String name, String email, String paymentMethodId) {
		// 0.apiKeyの読み込み
		Stripe.apiKey = stripeApiKey;
		
		// 1.customer情報をnullに初期化
		Customer customer = null;
		
		// 2.https://docs.stripe.com/api/customers/createを参照してカスタマー情報を作成
		CustomerCreateParams cParams =
				  CustomerCreateParams.builder()
				    .setName(name)
				    .setEmail(email)
				    .build();

		// 2.エラーが出るので例外処理を追加
		try {
			customer = Customer.create(cParams);
			
			// 3.支払い情報に対して事前に作成したカスタマー情報を追加
			// https://docs.stripe.com/api/payment_methods/attachを参照
			PaymentMethod pResource = PaymentMethod.retrieve(paymentMethodId);
			PaymentMethodAttachParams pParams =
			  PaymentMethodAttachParams.builder().setCustomer(customer.getId()).build();
			pResource.attach(pParams);
			
			// 4.カード情報を更新(デフォルトの支払い情報をセット)
			// https://docs.stripe.com/payments/checkout/subscriptions/update-payment-details#set-default-payment-methodを参照
			CustomerUpdateParams cuParams =
			  CustomerUpdateParams.builder()
			    .setInvoiceSettings(
			      CustomerUpdateParams.InvoiceSettings.builder()
			        .setDefaultPaymentMethod(pResource.getId())
			        .build()
			    )
			    .build();
			
			customer.update(cuParams);
			
		} catch (StripeException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		return customer;
	}
    
	public Subscription createSubscription(String customerId) {
		
		// 0.サブスクリプション情報をNULLで初期化
		Subscription subscription = null;
		
		// 1.サブスクリプション情報を登録
		// https://docs.stripe.com/api/subscriptions/createを参照して実施
		SubscriptionCreateParams params =
				  SubscriptionCreateParams.builder()
				    .setCustomer(customerId)
				    .addItem(
				      SubscriptionCreateParams.Item.builder()
				        .setPrice(premiumPlanId)
				        .build()
				    )
				    .build();
		
		// 2.エラーが出るので例外処理を追加 
		try {
			subscription = Subscription.create(params);
		} catch (StripeException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
		// 3.サブスクリプション情報を返却
		return subscription;
	}
	
	
	public void cancelSubscription(String subscriptionId) {
		// 0.apiKeyの読み込み
		Stripe.apiKey = stripeApiKey;
		
		// 1.サブスクリプションをキャンセルする
		// https://docs.stripe.com/api/subscriptions/cancelを参照して実施
		Subscription resource = null;
		try {
			resource = Subscription.retrieve(subscriptionId);
			SubscriptionCancelParams params = SubscriptionCancelParams.builder().build();
			resource.cancel(params);
		} catch (StripeException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}	
    
	public String createStripeSession(SignupForm signupForm, HttpServletRequest httpServletRequest) {
		Stripe.apiKey = stripeApiKey;
		String requestUrl = new String(httpServletRequest.getRequestURL());
		SessionCreateParams params =
			SessionCreateParams.builder()
				.addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
				.addLineItem(
						SessionCreateParams.LineItem.builder()
						.setPriceData(
								SessionCreateParams.LineItem.PriceData.builder()
								.setProductData(
										SessionCreateParams.LineItem.PriceData.ProductData.builder()
										.setName(signupForm.getName() + "の月額料金")
										.build())
								.setUnitAmount((long) signupForm.getPrice())
								.setCurrency("jpy")
								.build())
						.setQuantity(1L)
						.build())
				.setMode(SessionCreateParams.Mode.SUBSCRIPTION)
				.setSuccessUrl(requestUrl.replaceAll("/", ""))
				.setCancelUrl(requestUrl.replace("/signup", ""))
				.setPaymentIntentData(
					SessionCreateParams.PaymentIntentData.builder()
					.putMetadata("name", signupForm.getName())
						.putMetadata("furigana", signupForm.getFurigana())
						.putMetadata("phoneNumber", signupForm.getPhoneNumber())
						.putMetadata("email", signupForm.getEmail())
						.putMetadata("birthday", signupForm.getBirthday().toString())
						.putMetadata("occupation", signupForm.getOccupation().toString())
						.putMetadata("role", signupForm.getRole())
						.putMetadata("password", signupForm.getPassword())
						.putMetadata("passwordConfirmation", signupForm.getPasswordConfirmation())
						.build())
				.build();
		try {
			Session session = Session.create(params);
			return session.getId();
		} catch (StripeException e) {
			e.printStackTrace();
			return "";
		}
	}  
}