<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Header Example</title>
<link rel="stylesheet" href="../assets/css/bootstrap.min.css">
<link rel="stylesheet" href="../assets/css/header.css">
</head>
<body>

	<!-- Top Bar -->
	<div class="top-bar"></div>

	<!-- Header -->
	<nav class="navbar navbar-expand-lg navbar-light">
		<div
			class="container d-flex justify-content-between align-items-center">
			<a class="navbar-brand" href="#">CHOCOHEAVEN</a>
			<div class="search-bar d-flex">
				<input class="form-control" type="search" placeholder="Search"
					aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Search</button>
				<a><img alt="" src="../assets/icons/avatar.png">Login</a> <a><img
					alt="" src="../assets/icons/cart.png"></a>
			</div>
		</div>
	</nav>

	<!-- Menu -->
	<nav class="navbar navbar-expand-lg navbar-light">
		<div class="container">
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link" href="#">BEST
							SELLERS</a></li>
					<li class="nav-item"><a class="nav-link" href="#">CHOCOLATE</a></li>
					<li class="nav-item"><a class="nav-link" href="#">SALES &
							DEALS</a></li>
					<li class="nav-item"><a class="nav-link" href="#">ABOUT
							CHOCOHEAVEN</a></li>
					<li class="nav-item"><a class="nav-link" href="#">GROCERY
							AISLE</a></li>
				</ul>
			</div>
		</div>
	</nav>

</body>
</html>
