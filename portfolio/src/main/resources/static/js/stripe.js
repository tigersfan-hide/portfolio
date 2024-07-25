const stripe = Stripe('pk_test_51OwE40P33UzMHrzCztO6MRY6NsSIQ3aZxjrTDQmKswbvLGwtZuaNxJYVOKas958BkY5zjpE22OC5eCx4A05xr0nx00Uvd436QC');

stripe.redirectToCheckout({
//	sessionId:  /*[[${sessionId}]]*/ "sessionId"
//	}).then(function (result) {
	sessionId: document.getElementById('stripe-session-id').value
}).then(function (result) {
		if (result.error) {
			console.error(result.error.message);
			}
		});