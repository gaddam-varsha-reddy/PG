var path="http://3.19.32.109:8080/";
function formopen(){
document.getElementById("delform").style.display="block";
document.getElementById("middlediv").style.display = "none";
}
function toaster(){
   document.getElementById("hide").style.display="none";
   }

        function disp(){
        document.getElementById("open").style.display="block";
        document.getElementById("middlediv").style.display = "none";

        }

       async function delbook(){

       if(document.getElementById("roomno").value==""){
       alert("Enter Room No");}
       else if(document.getElementById("emailid").value==""){
       alert("Enter Email");}

//       document.getElementById("delform").style.display="none";

   var requestOptiona1 = {
  method: 'GET',
  redirect: 'follow'
};

 var requestOptionsa2 = {
  method: 'GET',
  redirect: 'follow'
};
var requestOptionsa3 = {
  method: 'GET',
  redirect: 'follow'
};
var requestOptionsa4 = {
  method: 'PUT',
  redirect: 'follow'
};
var requestOptionsa5 = {
  method: 'PUT',
  redirect: 'follow'
};
var requestOptionsa6 = {
  method: 'POST',
  redirect: 'follow'
};

let roomno=document.getElementById("roomno").value;
let floorno=document.getElementById("floorno").value;
let bedno=document.getElementById("bedno").value;
let email=document.getElementById("emailid").value;

let f=await fetch(`${path}varsha/bed?roomNo=${roomno}&floorNo=${floorno}&bedNo=${bedno}`, requestOptiona1)
let f1=await f.json();
console.log("bedId" + f1);
if(f1!=-1){

  let g=await fetch(`${path}varsha/searchUser?email=${email}`, requestOptionsa2)
  let g1=await g.json();
  console.log("userId" + g1);
  if(g1!=-1){
         let h=await fetch(`${path}varsha/searchbooking?userId=${g1}&bedId=${f1}`, requestOptionsa3)
         let h1=await h.json();
          console.log("bookingId" + h1);
           if(h1!=-1){
await fetch(`${path}varsha/booking?userId=${g1}&bedId=${f1}`, requestOptionsa4)

console.log("updated booking status");
await fetch(`${path}varsha/bed?bedId=${f1}`, requestOptionsa5)

console.log("updated bed status");
await fetch(`${path}varsha/userdetails?userId=${g1}`, requestOptionsa6)
console.log("updated user status");

                 }
           }
       }
  }
            async function bookRoom(){
            var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;

            if(document.getElementById("fname").value.length == 0)
              {
               alert("Enter First Name")
              }
             else if(document.getElementById("lname").value.length == 0)
              {
               alert("Enter Last Name")
              }
             else if(document.getElementById("mobileno").value.length != 10)
              {
               alert("Enter 10 digit mobile no")
              }
              else if(document.getElementById("email").value.match(mailformat))
{
            var requestOptions = {
  method: 'POST',
  redirect: 'follow'
};
 var requestOptions1 = {
  method: 'GET',
  redirect: 'follow'
};
            document.getElementById("open").style.display="none";
            console.log("button clicked");
             let bedId=document.getElementById("mySelect").value;
             console.log("bedId" +bedId);
             let fn  = document.getElementById("fname").value;
             let ln = document.getElementById("lname").value;
             let mn  = document.getElementById("mobileno").value;
             let email  = document.getElementById("email").value;
             let dob  = document.getElementById("dob").value;
      var t = JSON.stringify({
              "id" : 0,
  "firstName" : fn,
  "lastName" : ln,
  "mobileNo" : mn,
  "email" : email,
  "dob" : dob,
  "isActive" : true
         });

         var requestOptions12 = {
  method: 'GET',
  redirect: 'follow'
};

             var requestOptions5 = {
  method: 'POST',
  body: t,
  redirect: 'follow'
};
          await fetch(`${path}varsha/userdetails`, requestOptions5)
const a=await fetch(`${path}varsha/searchUser?email=${email}`, requestOptions1)
const userId=await a.json();
console.log("userId" +userId);
await fetch(`${path}varsha/booking?userId=${userId}&bedId=${bedId}`,requestOptions5)

var requestOptions9 = {
  method: 'POST',
  redirect: 'follow'
};

 await fetch(`${path}varsha/bed?bedId=${bedId}`, requestOptions9)
  document.getElementById("hide").style.display="block";

<!-- var requestOptions9 = {-->
<!--  method: 'POST',-->
<!--  redirect: 'follow'-->
<!--};-->

<!--fetch(`${path}varsha/bed?bedId=${}`, requestOptions9)-->
<!--  .then(response => response.text())-->
<!--  .then(result => console.log(result))-->
<!--  .catch(error => console.log('error', error));-->
            }
            else{
            alert("Enter valid email ");
            }
            }

            async function load() {
                const response1 = await fetch(`${path}varsha/booking`)
            let data = await response1.json();
            let i=0;
            let c=document.createElement("tr");
            var td0 = document.createElement("td");
            var td1 = document.createElement("td");
            var td2 = document.createElement("td");
            var td3 = document.createElement("td");
            var td4 = document.createElement("td");
            var td5 = document.createElement("td");
            var td6=document.createElement("td");
            var txt="";
             for(i=0;i<data.length;i++){
                c=document.createElement("tr");
                td0 = document.createElement("td");
                td1 = document.createElement("td");
                td2 = document.createElement("td");
                td3 = document.createElement("td");
                td4 = document.createElement("td");
                td5 = document.createElement("td");
                td6=document.createElement("td");
                txt="";
                 txt ="#" + i;
                 txt+=i*4;
                 txt+=i;
                 td0.innerHTML=txt;
                 txt="";
                 txt =data[i]['email'];
                 td1.innerHTML=txt;
                 txt="";
                 txt =data[i]['roomNo'];
                 td2.innerHTML=txt;
                 txt="";
                 txt =data[i]['floorNo'];
                 td3.innerHTML=txt;
                 txt="";
                 txt =data[i]['bedNo'];
                 td4.innerHTML=txt;
                 txt="";
                  txt =data[i]['cost'];
                td5.innerHTML=`<i class='fa-solid fa-indian-rupee-sign'></i>`;
                 td5.innerHTML+=" "+txt;
                 txt="";
                 txt=data[i]['isActive'];
                 if(txt==true){
                    txt="Check-in";
                 }
                 else{
                    txt="check-out";
                 }
                 td6.innerHTML=txt;
                 c.appendChild(td0);
                  c.appendChild(td1);
                  c.appendChild(td2);
                  c.appendChild(td3);
                  c.appendChild(td4);
                  c.appendChild(td5);
                  c.appendChild(td6);
                 //console.log(txt);

                 document.getElementById("tdata").appendChild(c);
             }
            console.log(data);
           let  response2 = await fetch(`${path}varsha/vaccantroom`)
            data = await response2.json();
            console.log(data);
             i=0;
  var x = document.getElementById("mySelect");
 for(i=0;i<data.length;i++){
     var option = document.createElement("option");
     option.value =data[i]['bedId'] ;
    option.text = "Room:" +data[i]['roomNo'] +" Bed:"+ data[i]['bedNo'] ;
    x.add(option);

 }
            }
