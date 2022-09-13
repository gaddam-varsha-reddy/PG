var path="http://3.19.32.109:8080/";
   function toaster(){
   document.getElementById("hide").style.display="none";
   }

    function disp(){
        document.getElementById("open").style.display="block";
        //document.getElementById("open").className = "modal-open";
        document.getElementById("data").style.display="none";
        }
           async function clk(){
            if(document.getElementById("roomno").value.length == 0)
              {
               alert("Enter Room No")
              }
               else if(document.getElementById("floorno").value.length == 0)
                 {
                    alert("Enter Floor No")
                 }
                     else if(document.getElementById("totalbeds").value.length == 0)
                       {
                        alert("Enter Total Beds")
                     }
else{

//             document.getElementById("open").style.display="none";
                var myHeaders = new Headers();
myHeaders.append("Content-Type", "application/json");
console.log("loaded");

var requestOptions10 = {
  method: 'GET',
  redirect: 'follow'
};
roomno=document.getElementById("roomno").value;
floorno=document.getElementById("floorno").value
console.log(roomno + " " +floorno);
let b1=await fetch(`${path}varsha/bed?roomNo=${roomno}&floorNo=${floorno}&bedNo=1`, requestOptions10)
 b=await b1.json();
 console.log(b);
 if(b==-1){
  document.getElementById("hide").style.display="block";
  }

var raw = JSON.stringify({
  "id": 1,
  "roomNo": document.getElementById("roomno").value,
  "floorNo": document.getElementById("floorno").value,
  "totalBeds": document.getElementById("totalbeds").value
});

var requestOptions = {
  method: 'POST',
  headers: myHeaders,
  body: raw,
  redirect: 'follow'
};

fetch("${path}varsha/PG/room", requestOptions)
  .then(response => response.text())
  .then(result => console.log(result))
  .catch(error => console.log('error', error));



            }
            }

            async function load() {
                const response = await fetch(`${path}varsha/room`)
            let data = await response.json();
            let i=0;
            let c=document.createElement("tr");

            var td1 = document.createElement("td");
            var td2 = document.createElement("td");
            var td3 = document.createElement("td");
            var td4 = document.createElement("td");
            var td5 = document.createElement("td");
            var td6=document.createElement("td");
            var txt="";
             for(i=0;i<data.length;i++){
                c=document.createElement("tr");

                td1 = document.createElement("td");
                td2 = document.createElement("td");
                td3 = document.createElement("td");
                td4 = document.createElement("td");
                td5 = document.createElement("td");
                td6=document.createElement("td");

                 txt="";
                 txt =data[i]['roomNo'];
                 td1.innerHTML=txt;
                 txt="";
                 txt =data[i]['floorNo'];
                 td2.innerHTML=txt;
                 txt="";
                 txt =data[i]['totalBeds'];
                 td3.innerHTML=txt;
                 txt="";
                 txt =data[i]['bedNo'];
                 td4.innerHTML=txt;
                 txt="";
                 txt =data[i]['cost'];
                 td5.innerHTML=`<i class='fa-solid fa-indian-rupee-sign'></i>`;
                 td5.innerHTML+=" "+txt;

                 txt="";
                 txt=data[i]['isFull'];
                 if(txt==true){
                    txt="Occupied";
                 }
                 else{
                    txt="Empty";
                 }
                 td6.innerHTML=txt;

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
            }
