function sendLogin(){
	console.log("sendLogin started.");
	let loginForm = document.loginForm;
	let username = loginForm.username.value;
	let password = loginForm.password.value;
	
	let loginTemplate = {
							user_name: username,
							pass_word: password,
	};
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
			if(this.ready === 4 && this.status === 200){
				sessionStorage.setItem('currentUser', this.response.Text);
				window.location = "http://localhost:8080/project-1/home/mainmenu.html";
				}
			
			if(this.readyState === 4 && this.status === 204){
				alert("Failed to login! Username or password is incorrect.");
			}};
	xhr.open("POST", "http://localhost:8080/project-1/login.main");
	xhr.send(JSON.stringify(loginTemplate));
}