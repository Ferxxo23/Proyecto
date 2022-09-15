<!DOCTYPE html>
<!-- Designined by CodingLab | www.youtube.com/codinglabyt -->
<html lang="en" dir="ltr">

<head>
  <meta charset="UTF-8">
  <title> Modulo de inventario | MDIPS </title>
  <link rel="stylesheet" href="css/style.css">
  <!-- Boxicons CDN Link -->
  <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.0/font/bootstrap-icons.css">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>
<main>
  <a href="../dashboard inventario/principalAdmin.html" target="principal"></a>
  <div class="sidebar">
    <div class="logo-details">
      <i class='bx bxl-c-plus-plus'></i>
      <span class="logo_name">MDIPS</span>
    </div>
    <ul class="nav-links">
      <li>
        <a href="#" class="active">
          <i class='bx bx-grid-alt'></i>
          <span class="links_name">FORMULARIOS</span>
        </a>
      </li>
      <li>
        <a href="/catalogo_productos/nuevo">
          <i class='bx bx-box'></i>
          <span class="links_name">Catalogo</span>
        </a>
      </li>
      <li>
        <a href="/carritos/nueva">
          <i class='bx bx-list-ul'></i>
          <span class="links_name">Carrito</span>
        </a>
      </li>
      <li>
      <a href="/promociones/nueva">
        <i class='bx bx-list-ul'></i>
        <span class="links_name">Promociones</span>
      </a>
    </li>
      <li>
        <a href="#" class="active">
          <i class='bx bx-grid-alt'></i>
          <span class="links_name">REPORTES</span>
        </a>
      </li>
      <li>
        <a href="/catalogo_productos">
          <i class='bx bx-message'></i>
          <span class="links_name">Lista catalogo de productos</span>
        </a>
      </li>
      <li>
        <a href="/carritos">
          <i class='bx bx-cog'></i>
          <span class="links_name">Lista carrito de productos</span>
        </a>
      </li>
      <li>
      <a href="/carritos">
        <i class='bx bx-cog'></i>
        <span class="links_name">Lista de promociones</span>
      </a>
    </li>
      <li class="log_out">
        <a href="/login?logout">
          <i class='bx bx-log-out'></i>
          <span class="links_name">Salir</span>
        </a>
      </li>
    </ul>
  </div>
    <section class="home-section">
      <nav>
        <div class="sidebar-button">
          <i class='bx bx-menu sidebarBtn'></i>
          <span class="dashboard">Dashboard</span>
        </div>
        <div class="search-box">
          <input type="text" placeholder="Search...">
          <i class='bx bx-search'></i>
        </div>
        <div class="profile-details">
          <img src="images/profile.jpg" alt="">
          <span class="admin_name">Prem Shahi</span>
          <i class='bx bx-chevron-down'></i>
        </div>
      </nav>
      <iframe name="principal" src="../dashboard inventario/principalAdmin.html" frameborder="0"></iframe>
      <footer class="w-100  d-flex  align-items-center justify-content-center flex-wrap">
        <p class="fs-5 px-3  pt-3">MDIPS &copy; Diseñado por : <br> <br>
          Andres Urrea <br>
          David Ramirez <br>
          Antony lopez <br>
          Luis Jimenez <br>
        </p>
        <div id="iconos">
          <a href="#"><i class="bi bi-facebook"></i></a>
          <a href="#"><i class="bi bi-twitter"></i></a>
          <a href="#"><i class="bi bi-instagram"></i></a>
        </div>
      </footer>
    </section>
</main>


  <script>
    let sidebar = document.querySelector(".sidebar");
    let sidebarBtn = document.querySelector(".sidebarBtn");
    sidebarBtn.onclick = function () {
      sidebar.classList.toggle("active");
      if (sidebar.classList.contains("active")) {
        sidebarBtn.classList.replace("bx-menu", "bx-menu-alt-right");
      } else
        sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
    }
  </script>


</body>

</html>