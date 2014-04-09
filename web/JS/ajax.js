$(function() { 
$( "#slider" ).slider({ 
   stop: function(event, ui) {
          $("#load_image").show();
          $.ajax({
          url: "ajax.php",
          cache: false,
          async: false,
          data: "",
          success: function(html){ //got the data

            $("#load_image").hide(); // hide ajax loader         
            $("#result").html(html);        // show downloaded content
          }
        });

     }
    });
});