let main = {
    init : function (){
        let _this = this;

        $("#submitBtn").on("click", function(){
            _this.save();
        });
    },
    save : function (){
      console.log("save function start");

      let data = {
          name1 : $("#name1").val(),
          name2 : $("#name2").val(),
          name3 : $("#name3").val(),
          description : $("#description").val()
      }
      $.ajax({
          url : "/author/insert",
          method : "POST",
          contentType : "application/json; charset=UTF-8",
          dataType : "json",
          data : JSON.stringify(data)
      }).done(function(result) {
          alert("등록이 완료되었습니다.")
          window.location.href = "/author/list"
      }).fail(function() {
          alert("등록이 실패하였습니다.")
          window.location.reload();
      })
    }
}


main.init();