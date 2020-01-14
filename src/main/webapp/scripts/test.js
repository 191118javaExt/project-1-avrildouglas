function sendFormData(){
	const reimburseForm = document.getElementById('reimburseForm');
	
	ReimburseForm.addEventListener('submit', function (e) {
		
		//e.preventDefault();
		
		const sendData = new SendData(this);
		const getParameters = new getURLParameters();
		
		fetch('login.php', {
			method: 'post',
			body: sendData
		}
			). then (function (response){
				return response.text();
			
		}). then(function (text) {
			console.log(text);
		}).catch(function(error) {
			console.error(error);
		})
	});		
}	
