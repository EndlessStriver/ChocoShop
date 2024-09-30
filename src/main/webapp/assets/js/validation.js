document.getElementById('registrationForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const firstName = document.getElementById('first-name').value.trim();
    const lastName = document.getElementById('last-name').value.trim();
    const username = document.getElementById('username').value.trim();
    const password = document.getElementById('password').value;
    const passwordConfirm = document.getElementById('password_confirm').value;
    const gender = document.querySelector('input[name="gender"]:checked');
    const dob = document.getElementById('dob').value;
    const tel = document.getElementById('tel').value.trim();
    const email = document.getElementById('email').value.trim();

    clearErrors();

    const isValid = checkInputs(firstName, lastName, username, password, passwordConfirm, gender, dob, tel, email);
    if (isValid) {
        document.getElementById('registrationForm').reset(); 
        alert('Form đã được gửi thành công!'); 
    }
});

function clearErrors() {
    document.getElementById('firstNameError').textContent = '';
    document.getElementById('lastNameError').textContent = '';
    document.getElementById('usernameError').textContent = '';
    document.getElementById('passwordError').textContent = '';
    document.getElementById('passwordConfirmError').textContent = '';
    document.getElementById('genderError').textContent = '';
    document.getElementById('dobError').textContent = '';
    document.getElementById('telError').textContent = '';
    document.getElementById('emailError').textContent = '';
}

function checkInputs(firstName, lastName, username, password, passwordConfirm, gender, dob, tel, email) {
    const namePattern = /^[\p{L}\s]+$/u; // Cho phép ký tự tiếng Việt
    
    if (!namePattern.test(firstName)) {
        document.getElementById('firstNameError').textContent = 'Họ không được chứa số hoặc ký tự đặc biệt.';
        return false;
    }
    if (!namePattern.test(lastName)) {
        document.getElementById('lastNameError').textContent = 'Tên không được chứa số hoặc ký tự đặc biệt.';
        return false;
    }

    const telPattern = /^\d{10}$/; 
    if (!telPattern.test(tel)) {
        document.getElementById('telError').textContent = 'Số điện thoại phải gồm 10 chữ số.';
        return false;
    }

    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; 
    if (!emailPattern.test(email)) {
        document.getElementById('emailError').textContent = 'Địa chỉ email không hợp lệ.';
        return false;
    }
    if (password.length < 6 || password.length > 12) {
        document.getElementById('passwordError').textContent = 'Mật khẩu phải có từ 6 đến 12 ký tự.';
        return false;
    }

    if (password !== passwordConfirm) {
        document.getElementById('passwordConfirmError').textContent = 'Mật khẩu không khớp.Vui lòng nhập lại.';
        return false;
    }

    // Kiểm tra năm sinh
    const birthYear = new Date(dob).getFullYear(); 
    const currentYear = new Date().getFullYear(); 
    if (birthYear >= currentYear) {
        document.getElementById('dobError').textContent = 'Năm sinh phải nhỏ hơn năm hiện tại.';
        return false;
    }

    return true; 
}

document.getElementById('first-name').addEventListener('blur', function() {
    const firstName = this.value.trim();
    const namePattern = /^[\p{L}\s]+$/u;
    if (!namePattern.test(firstName)) {
        document.getElementById('firstNameError').textContent = 'Họ không được chứa số hoặc ký tự đặc biệt.';
    } else {
        document.getElementById('firstNameError').textContent = '';
    }
});

// Cập nhật kiểm tra trên sự kiện blur cho lastName
document.getElementById('last-name').addEventListener('blur', function() {
    const lastName = this.value.trim();
    const namePattern = /^[\p{L}\s]+$/u;
    if (!namePattern.test(lastName)) {
        document.getElementById('lastNameError').textContent = 'Tên không được chứa số hoặc ký tự đặc biệt.';
    } else {
        document.getElementById('lastNameError').textContent = '';
    }
});

document.getElementById('tel').addEventListener('blur', function() {
    const tel = this.value.trim();
    const telPattern = /^\d{10}$/;
    if (!telPattern.test(tel)) {
        document.getElementById('telError').textContent = 'Số điện thoại phải gồm 10 chữ số.';
    } else {
        document.getElementById('telError').textContent = '';
    }
});

document.getElementById('email').addEventListener('blur', function() {
    const email = this.value.trim();
    const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailPattern.test(email)) {
        document.getElementById('emailError').textContent = 'Địa chỉ email không hợp lệ.';
    } else {
        document.getElementById('emailError').textContent = '';
    }
});

document.getElementById('password_confirm').addEventListener('blur', function() {
    const password = document.getElementById('password').value;
    const passwordConfirm = this.value;
    if (password !== passwordConfirm) {
        document.getElementById('passwordConfirmError').textContent = 'Mật khẩu không khớp.Vui lòng nhập lại.';
    } else {
        document.getElementById('passwordConfirmError').textContent = '';
    }
});

document.getElementById('dob').addEventListener('blur', function() {
    const dob = this.value;
    const birthYear = new Date(dob).getFullYear();
    const currentYear = new Date().getFullYear(); 
    if (birthYear >= currentYear) {
        document.getElementById('dobError').textContent = 'Năm sinh phải nhỏ hơn năm hiện tại.';
    } else {
        document.getElementById('dobError').textContent = '';
    }
});

document.getElementById('password').addEventListener('blur', function() {
    const password = this.value;
    if (password.length < 6 || password.length > 12) {
        document.getElementById('passwordError').textContent = 'Mật khẩu phải có từ 6 đến 12 ký tự.';
    } else {
        document.getElementById('passwordError').textContent = ''; 
    }
});
