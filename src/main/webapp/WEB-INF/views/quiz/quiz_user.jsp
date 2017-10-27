<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%>
<!-- Main page of Announcement -->
<x:page> 
    <jsp:attribute name="css">
    </jsp:attribute> 
    <jsp:attribute name="script">
    </jsp:attribute>
<jsp:body>
		<div class="container">

      <!-- Page Heading -->
      <h1 class="my-4">Online Health System
        <small> Quiz</small>
      </h1>

      <!-- Project One -->
      <div class="row">
        <div class="col-md-7">
          <a href="#">
            <img class="img-fluid rounded mb-3 mb-md-0" src="http://placehold.it/700x300" alt="">
          </a>
        </div>
        <div class="col-md-5">
          <h3>Quiz One</h3>
          <p>The Healthy Eating Quiz is a general guide, designed to help you rate how healthy your eating habits are. It will help to identify areas in which you are already eating a wide variety of foods and areas where you may be able to improve. At the end of the quiz, you will receive a score with general feedback on your current eating patterns. It will also give you suggestions for ways to increase the variety of foods in your diet. </p>
          <a class="btn btn-primary" href="#">View Project</a>
        </div>
      </div>

      <!-- /.row -->

      <hr>

      <!-- Pagination -->
      <ul class="pagination justify-content-center">
        <li class="page-item">
          <a class="page-link" href="#" aria-label="Previous">
            <span aria-hidden="true">&laquo;</span>
            <span class="sr-only">Previous</span>
          </a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#">1</a>
        </li>
        <li class="page-item">
          <a class="page-link" href="#" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
            <span class="sr-only">Next</span>
          </a>
        </li>
      </ul>

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script> 			  
    </jsp:body>
</x:page>
