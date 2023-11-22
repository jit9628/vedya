function successResponseMessage(msg) {
	Swal.fire({
		position: 'top-end',
		position: 'center',
		icon: 'success',
		title: msg,
		showConfirmButton: false,
		timer: 8000
	})

	return 1;

}


function FailureResponseMessage(msg,icon) {
	Swal.fire({
		position: 'top-end',
		position: 'center',
		icon: icon,
		title: msg,
		showConfirmButton: false,
		timer: 8000
	})

	return 1;

}