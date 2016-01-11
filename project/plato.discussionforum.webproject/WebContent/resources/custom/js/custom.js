
$(document).ready(function() {
    $('#addMoreFiles').click(function() {
        $('#fileUpload').append(
                '<label for="file">Select Files</label> <input type="file" name="file" size=50 multiple/>');
    });
    
    $(".js-example-basic-single").select2();
/*    function confirm_alert(node) {
        return confirm("Please click on OK to continue.");
    }  */  
});

function confirm_delete(node) {
    return confirm("Are you sure for delete");
}