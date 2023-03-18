const projectName = 'survey-form';
function getAns(){
    /* School Size */
  const collection1 = document.getElementsByName("size");
  for (let i = 0; i < collection1.length; i++) {
    if (collection1[i].checked == true) {
      var schoolSize = i + 1;
    }
  }
  window.location.href = "answers.html?var=" + schoolSize;
  document.getElementById("insert1").innerHTML = schoolSize;
  
  /* School Gender */
  const collection2 = document.getElementsByName("gender");
  for (let i = 0; i < collection2.length; i++) {
    if (collection2[i].checked == true) {
      var schoolGender = i + 1;
    }
  }
  window.location.href = "answers.html?var=" + schoolGender;
  document.getElementById("insert2").innerHTML = schoolGender;
  /* School Race */
  const collection3 = document.getElementsByName("race");
  for (let i = 0; i < collection3.length; i++) {
    if (collection3[i].checked == true) {
      var schoolRace = i + 1;
    }
  }
  document.getElementById("insert3").innerHTML = schoolRace;
  /* School Undergrads */
  const collection4 = document.getElementsByName("undergrads");
  for (let i = 0; i < collection4.length; i++) {
    if (collection4[i].checked == true) {
      var schoolUndergrads = i + 1;
    }
  }
  document.getElementById("insert4").innerHTML = schoolUndergrads;
  /* School Greek */
  const collection5 = document.getElementsByName("greek");
  for (let i = 0; i < collection5.length; i++) {
    if (collection5[i].checked == true) {
      var schoolGreek = i + 1;
    }
  }
  document.getElementById("insert5").innerHTML = schoolGreek;
  /* School Aid */
  const collection6 = document.getElementsByName("aid");
  for (let i = 0; i < collection6.length; i++) {
    if (collection6[i].checked == true) {
      var schoolAid = i + 1;
    }
  }
  document.getElementById("insert6").innerHTML = schoolAid;
  /* School SFR */
  const collection7 = document.getElementsByName("SFR");
  for (let i = 0; i < collection7.length; i++) {
    if (collection7[i].checked == true) {
      var schoolSFR = i + 1;
    }
  }
  document.getElementById("insert7").innerHTML = schoolSFR;
  }
