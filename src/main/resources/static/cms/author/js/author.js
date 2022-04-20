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
      console.log("insert data : " + data);
    }
}


main.init();