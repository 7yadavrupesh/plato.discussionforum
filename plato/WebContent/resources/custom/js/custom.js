
$(document).ready(function() {
    $('#addMoreFiles').click(function() {
        $('#fileUpload').append(
                '<div> <input type="file" name="file" size=50 multiple /></div><br>');
    });
    
   // $(".js-example-basic-single").select2();
/*    function confirm_alert(node) {
        return confirm("Please click on OK to continue.");
    }  */  
});

function confirm_delete(node) {
    return confirm("Are you sure for delete");
}