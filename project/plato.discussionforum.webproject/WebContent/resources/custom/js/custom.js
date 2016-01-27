
$(document).ready(function() {
    $('#addMoreFiles').click(function() {
        $('#fileUpload').append(
                '<div  class="form-group"> <input class="fileUploadSizeLimit" type="file" name="file" size=50 multiple /></div>');
    });
    
   // $(".js-example-basic-single").select2();
/*    function confirm_alert(node) {
        return confirm("Please click on OK to continue.");
    }  */  
});

function confirm_delete(node) {
    return confirm("Are you sure for delete");
}

// file upload validation code
$gblFileLength=0;
$(document).on('change','input.fileUploadSizeLimit', function() {
	  var loopvariable=0;
	  $Bytes = 0;
	$("input[type=file]").each(function() {
		//this.files[0].size gets the size of your file.
		  var MaxSize = 1000000;
		  var numOfFiles = this.files.length;
		  var i = 0;
		  for(i=0;i<numOfFiles;i++){
			  $Bytes+=this.files[i].size;
		  }
		  
		  if($Bytes>MaxSize){
			  alert("Allowed file size exceeded. (Max. 1 MB)")
			  this.value=null;
		  }
        });
	});