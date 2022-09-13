var path="http://3.19.32.109:8080/";
    async function dashload() {
      let c;
      let option;
      let txt;

      const response1 = await fetch(`${path}varsha/roomcount`)
      let data1 = await response1.json();
      console.log("roomcount"+data1);
      c=document.createElement("div");
      option = document.createElement("p");
      txt=data1;
      option.innerHTML=txt;
      c.appendChild(option);
      c.classList.add("fonts");
      document.getElementById("col1").append(c);
      const response2 = await fetch(`${path}varsha/bedcount`)
      let data2 = await response2.json();
      console.log("bedcount"+data2);
      c=document.createElement("div");
      option = document.createElement("p");
      txt=data2;
      option.innerHTML=txt;
      c.appendChild(option);
      c.classList.add("fonts");
      document.getElementById("col2").append(c);
      const response3 = await fetch(`${path}varsha/activebooking`)
      let data3 = await response3.json();
      console.log("activebooking" +data3);
      c=document.createElement("div");
      option = document.createElement("p");
      txt=data3;
      option.innerHTML=txt;
      c.appendChild(option);
      c.classList.add("fonts");
      document.getElementById("col3").append(c);
      const response4 = await fetch(`${path}varsha/paymentcount`)
      let data4 = await response4.json();

      c=document.createElement("div");
      option = document.createElement("p");
      txt=data4;
      option.innerHTML=txt;
      c.appendChild(option);
      c.classList.add("fonts");
      document.getElementById("col4").append(c);
      console.log("paymentcount"+data4);


      const response7 = await fetch(`${path}varsha/floorcount`)
      let data7 = await response7.json();
      console.log("total floors" +data7);
      c=document.createElement("div");
      option = document.createElement("p");
      txt=data7;
      option.innerHTML=txt;
      c.appendChild(option);
      c.classList.add("fonts");
      document.getElementById("col7").append(c);
      }
