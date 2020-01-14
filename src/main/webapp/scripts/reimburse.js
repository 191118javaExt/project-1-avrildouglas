function sendReimburse(){
	console.log("sendReimburse started.");
	let reimburseForm = document.reimburseForm;
	let submitby= reimburseForm.submitby.value;
	let reimamt= reimburseForm.reimamt.value;
	let reimtype= reimburseForm.reimtype.value;
	let reimdescr= reimburseForm.reimdescr.value;
	let submitdte= reimburseForm.submitdte.value;
	let reimrecpt= reimburseForm.reimrecpt.value;
	let reimstat= reimburseForm.reimstat.value;
	let processdte= reimburseForm.processdte.value;
	let processby= reimburseForm.processby.value;
	let username = reimburseForm.username.value;

	
	let reimburseTemplate = {
							submit_by: submitby,
							reim_amt: reimamt,
							reim_type: reimtype,
							reim_descr: reimdescr,
							submit_dte: submitdte,
							reim_recpt: reimrecpt,
							reim_stat: reimstat,
							process_dte: processdte,
							process_by: processby,
							user_name: username
	
	};
	
	let xhr = new XMLHttpRequest();
	
	xhr.onreadystatechange = function(){
			if(this.ready === 4 && this.status === 200){
				sessionStorage.setItem('currentReimburse', this.response.Text);
				// show success
				alert("The Reimbursement has been successfully sent for "+response.user_name);
       			window.location = "http://localhost:8080/project-1/home/mainmenu.html";
				}
			
			if(this.readyState === 4 && this.status === 204){			
			}
				alert("Failed to submit! Resubmit Reimbursement Form.");
			}};
	xhr.open("POST", "http://localhost:8080/project-1/reimburse.main");
	xhr.send(JSON.stringify(reimburseTemplate));
	