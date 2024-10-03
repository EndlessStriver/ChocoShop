<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignUp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha284-EVSTQN2/azprG1Anm2QDgpJLIm9Nao0Yz1ztcQTwFspd2yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="../assets/css/SignUp.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<body>

    <div class="container d-flex justify-content-center align-items-center ">
        <form id="registrationForm" class="form-container bg-white p-4 shadow-lg rounded">
            <h2 class="text-center mb-4">ĐĂNG KÝ TÀI KHOẢN</h2>
            <div class="mb-2 row g-1">
                <div class="col">
                    <input type="text" class="form-control" id="first-name" name="firstName" placeholder="FirstName" required>
                    <div id="firstNameError" class="error-message"></div>
                </div>
                <div class="col">
                    <input type="text" name="lastName" id="last-name" class="form-control" placeholder="LastName"required>
                    <div id="lastNameError" class="error-message"></div>
                </div>
            </div>
            <div class="mb-2">
                <input type="text" class="form-control" id="username" name="username" placeholder="UserName"required>
                <div id="usernameError" class="error-message"></div>
            </div>
            <div class="mb-2">
                <input type="password" class="form-control" id="password" name="password" placeholder="password" required>
                <div id="passwordError" class="error-message"></div>
            </div>
            <div class="mb-2">
                <input type="password" class="form-control" id="password_confirm" name="password_confirm" placeholder="Re-enter password"required>
                <div id="passwordConfirmError" class="error-message"></div>
            </div>
            <div class="mb-2 row">
                <label class="form-label required">Giới tính</label>
                <div class="form-check col">
                    <input class="form-check-input" type="radio" name="gender" id="genderMale" value="male" required checked>
                    <label class="form-check-label" for="genderMale">Nam</label>
                </div>
                <div class="form-check col">
                    <input class="form-check-input" type="radio" name="gender" id="genderFemale" value="female" required>
                    <label class="form-check-label" for="genderFemale">Nữ</label>
                </div>
                <div id="genderError" class="error-message"></div>
            </div>
            <div class="mb-2">
                <label for="dob" class="form-label required">Ngày sinh</label>
                <input type="date" class="form-control" id="dob" name="birthday" required>
                <div id="dobError" class="error-message"></div>
            </div>
            <div class="mb-2">
                <input type="tel" class="form-control" id="tel" name="phoneNumber" placeholder="Số Điện Thoại" required>
                <div id="telError" class="error-message"></div>
            </div>
            <div class="mb-2">
                <input type="email" class="form-control" id="email" name="email" placeholder="Email" required>
                <div id="emailError" class="error-message"></div>
            </div>
            <button type="submit" class="btn btn-primary w-100">Đăng ký</button>
           
            <div class="mt-4 text-center" style="font-size: 1.25rem;"> <p>Nếu bạn đã có tài khoản 
        <a href="../public/login.jsp" class="">Đăng nhập</a> </p>
    </div>
        </form>
    </div>

    <script src="../assets/js/validation.js"></script>
</body>
</html>
