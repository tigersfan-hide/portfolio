//package com.example.portfolio.controller;
//
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import com.example.portfolio.security.UserDetailsImpl;
//
//@Controller
//@RequestMapping("/subscription")
//public class SubscriptionController {
//	@GetMapping("/recommend")
//	public String index() {
//		return "/subscription/index";
//	}
//	
//	@PostMapping("/create")
//	public String create(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, 
//			@RequestParam String paymentMethodid, 
//			RedirectAttributes redirectAttributes) {
//		
//		
//		return null;
//	}
//	
//	
//	
//}

package com.example.portfolio.controller;

import java.sql.Timestamp;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.portfolio.entity.User;
import com.example.portfolio.form.ChangedGradeForm;
import com.example.portfolio.form.SignupForm;
import com.example.portfolio.repository.UserRepository;
import com.example.portfolio.security.UserDetailsImpl;
import com.example.portfolio.service.StripeService;
import com.example.portfolio.service.UserService;
import com.stripe.model.Customer;
import com.stripe.model.Subscription;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/subscription")
public class SubscriptionController {
	
	// 0.サービスと連動させるためにフィールドへ追加
    private final UserRepository userRepository;
    private final StripeService stripeService; 
	private final UserService userService;
//	private HttpSession session;
	
	// 0.サービスクラスと連携させるためにコンストラクタで初期化対応
	public SubscriptionController(
			StripeService stripeService,
			HttpSession session,
			UserService userService,
			UserRepository userRepository) {
		this.userRepository = userRepository;
		this.stripeService = stripeService;
		this.userService = userService;
//		this.session = session;
	}
	
    // 0.サブスクリプションをキャンセルするためにカスタマーIDをフィールドへ持たせる
    // (最終的にはデータベースのテーブル項目へ追加予定)
    private String subscriptionId = null;
    
	@GetMapping
	public String index() {
		return "/subscription/index";
	}

	// 0.キャンセル画面遷移を追加
	@GetMapping("/cancel")
	public String cancel() {
		return "/subscription/cancel";
	}

    // jsファイルで作成したPaymentMethodから受け取られたpaymentMethodIdを利用してカスタマーを作成、値を取得
    @PostMapping("/create")
    public String create(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl, SignupForm signupForm, @RequestParam String paymentMethodId, BindingResult bindingResult, RedirectAttributes redirectAttributes) {      
//    public String create(@RequestParam String paymentMethodId, RedirectAttributes redirectAttributes) {      

    	// セッション情報を取得
//    	SignupForm signupForm = (SignupForm)session.getAttribute("signupForm");
//    	if(signupForm == null) {
//            redirectAttributes.addFlashAttribute("errorMessage", "会員登録画面以外からのサブスクリプション登録は行えません");    
//            return "redirect:/";
//    	}
//    	
    	if(userDetailsImpl != null){
    		 // ログイン時の処理
    		// 1.ログインした際に格納されるuserDetailsImplを利用してログイン情報をテーブルから取得
    		// そのままログイン情報を利用すると、ユーザーが更新された後の場合に前の情報を見てしまうため
    		User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());
    		
    		// 2.カストマー情報をサービスクラス経由で作成、支払い情報へ追加して更新
    		// https://docs.stripe.com/api/customers/create
    		// https://docs.stripe.com/payments/checkout/subscriptions/update-payment-details#set-default-payment-method
    		Customer customer = stripeService.createCustomer(user.getName(), user.getEmail(), paymentMethodId);
    		
    		// 3.サブスクリプションの登録
        	// https://docs.stripe.com/api/subscriptions/create
        	Subscription subscription = stripeService.createSubscription(customer.getId());
        	
        	// 4.登録完了メッセージの登録
            redirectAttributes.addFlashAttribute("successMessage", "有料プランへの登録が完了しました。");    
            
            // (後から実施)サブスクリプションのキャンセルのためカスタマーIDをフィールド変数に持たせる
            subscriptionId = subscription.getId();
            
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            
            ChangedGradeForm changedGradeForm = new ChangedGradeForm(user.getId(), subscriptionId, timestamp);
            
            userService.changedGrade(changedGradeForm);
            
            // 5.一覧へリダイレクト
//          return "index";
          return "redirect:/";
            
    		}else{
    		 // ログインしていない場合の処理
    		Customer customer = stripeService.createCustomer(signupForm.getName(), signupForm.getEmail() ,paymentMethodId);
    		
    		Subscription subscription = stripeService.createSubscription(customer.getId());
    		
    		redirectAttributes.addFlashAttribute("successMessage", "有料プランへの登録が完了しました。");
    		
    		subscriptionId = subscription.getId();
    			
    		userService.create(signupForm);
    		
    		return "redirect:/";
    		}
    	
    } 
    	
    // サブスクリプションをキャンセル
    @PostMapping("/cancel")
    public String cancel(@AuthenticationPrincipal UserDetailsImpl userDetailsImpl,RedirectAttributes redirectAttributes) {
    	
    	// 1.サブスクリプションをキャンセルする
    	// https://docs.stripe.com/api/subscriptions/cancel
    	stripeService.cancelSubscription(subscriptionId);
    	
    	User user = userRepository.getReferenceById(userDetailsImpl.getUser().getId());
    	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    	ChangedGradeForm changedGradeForm = new ChangedGradeForm(user.getId(), "", timestamp);
    	
    	userService.changedGrade(changedGradeForm);
    	
    	// 2.キャンセル完了メッセージの登録
        redirectAttributes.addFlashAttribute("successMessage", "有料プランの登録をキャンセルしました");    
        
        // 3.一覧へリダイレクト
        return "redirect:/";
    } 
}
