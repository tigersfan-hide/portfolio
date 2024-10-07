const stripe = Stripe('pk_test_51OwE40P33UzMHrzCztO6MRY6NsSIQ3aZxjrTDQmKswbvLGwtZuaNxJYVOKas958BkY5zjpE22OC5eCx4A05xr0nx00Uvd436QC');

const elements = stripe.elements();
const cardElement = elements.create('card');
cardElement.mount('#card-element');

const cardholderName = document.getElementById('cardholder-name');
const cardButton = document.getElementById('card-button');

cardButton.addEventListener('click', async (ev) => {
ev.preventDefault();
  const {paymentMethod, error} = await stripe.createPaymentMethod({
      type: 'card',
      card: cardElement,
      billing_details: {
        name: cardholderName.value,
      },
    }
  );

  if (error) {
    // Display error.message in your UI.
    // エラーメッセージを書く
  } else {
//    resultContainer.textContent = "Created payment method: " + paymentMethod.id;
  const form = document.getElementById('payment-form');
  const input = document.createElement('input');
  input.setAttribute('type','hidden');
  input.setAttribute('name','paymentMethodId');
  input.setAttribute('value', paymentMethod.id);
  form.appendChild(input);
  form.submit();
  }
});

//const stripe = Stripe('pk_test_51OwE40P33UzMHrzCztO6MRY6NsSIQ3aZxjrTDQmKswbvLGwtZuaNxJYVOKas958BkY5zjpE22OC5eCx4A05xr0nx00Uvd436QC');
//
//stripe.redirectToCheckout({
//	sessionId:  /*[[${sessionId}]]*/ "sessionId"
//	}).then(function (result) {
//	sessionId: document.getElementById('stripe-session-id').value
//}).then(function (result) {
//		if (result.error) {
//			console.error(result.error.message);
//			}
//		});