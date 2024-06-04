package com.example.portfolio.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.portfolio.form.SignupForm;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class StripeService {
	@Value("${stripe.api-key}")
    private String stripeApiKey;
	
	public String createStripeSession(SignupForm signupForm, HttpServletRequest httpServletRequest) {
		Stripe.apiKey = "stripeApiKey";
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
