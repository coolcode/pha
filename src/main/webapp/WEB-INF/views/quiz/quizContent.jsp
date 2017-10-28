<%@ page session="false" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="x" tagdir="/WEB-INF/tags"%>
<!-- Main page of Announcement -->
<x:page> 
    <jsp:attribute name="css">
    </jsp:attribute> 
    <jsp:attribute name="script">
    </jsp:attribute>
<jsp:body>
		<div id="main">
			<!--main-bg-->
			<div class="main-bg">
				<!--main-bg-holder-->
				<div class="main-bg-holder">
					<!--aside-->
					<div class="aside">
						<div class="heading">
							<div class="holder">
								<h1>Take The Quiz</h1>
							</div>
						</div>
						<!--info-->
						<dl class="info">
							<dt>How long will the quiz take?</dt>
							<dd>The quiz will only take about 10-15 minutes.</dd>
						</dl>
					</div>
					<!--twocolumns-->
					<div id="twocolumns">
						<!--sidebar-->
						<div id="sidebar">
							<!--sub-nav-->
							<!-- <ul class="sub-nav">	
                    <li id="liNavSection1" class=""><a href="javascript: void();" onclick="javascript: void();" class="tab active" id="liContentTab-1" style="cursor: default;">About You</a></li>
                    <li id="liNavSection2" class=""><a href="javascript: void();" onclick="javascript: void();" class="tab" id="liContentTab-2" style="cursor: default;">Vegetables</a></li>
                    <li id="liNavSection3" class=""><a href="javascript: void();" onclick="javascript: void();" class="tab" id="liContentTab-3" style="cursor: default;">Fruit</a></li>
                    <li id="liNavSection4" class=""><a href="javascript: void();" onclick="javascript: void();" class="tab" id="liContentTab-4" style="cursor: default;">Protein foods<br> - Meat/Fish/Chicken</a></li>
                    <li id="liNavSection5" class=""><a href="javascript: void();" onclick="javascript: void();" class="tab" id="liContentTab-5" style="cursor: default;">Protein foods<br> - Vegetarian Alternatives</a></li>
                    <li id="liNavSection6" class=""><a href="javascript: void();" onclick="javascript: void();" class="tab" id="liContentTab-6" style="cursor: default;">Grains</a></li>
                    <li id="liNavSection7" class=""><a href="javascript: void();" onclick="javascript: void();" class="tab" id="liContentTab-7" style="cursor: default;">Dairy</a></li>
                    <li id="liNavSection8" class=""><a href="javascript: void();" onclick="javascript: void();" class="tab" id="liContentTab-8" style="cursor: default;">Water</a></li>
                    <li id="liNavSection9" class=""><a href="javascript: void();" onclick="javascript: void();" class="tab" id="liContentTab-9" style="cursor: default;">Sauces &amp; Condiments</a></li>
                    <li id="liNavSection10" class=""><a href="javascript: void();" onclick="javascript: void();" class="tab" id="liContentTab-10" style="cursor: default;">Submit</a></li>
                  
							</ul> -->
						</div>
						<!--content-->
						<div id="content">
							<!--block-->
							<div class="block">
								<!--text-->
								<div class="text" style="border: none;">

                  <!-- <form name="frmContentEdit" id="frmContentEdit" method="post" action="/result.asp" target="_blank" onKeyPress="return disableEnterKey();" onSubmit="submitAJAXContent(this, '', '', 'initQuiz(req.responseText); hideAJAXFloatingPage(\'\');', false, 'intEntryID'); return false;"> -->
                  <form name="frmContentEdit" id="frmContentEdit" method="post" action="/result.asp">
                    <input type="hidden" name="strAction" value="SUBMIT">
                
                      
                        <div id="divContentTab-1" class="tab-content" style="display: block;">
                          <div id="divQuizSection-1" style="display: block;">
  <h2>About You</h2>

	<div class="progressBar">
   
   <span style="height: 40px; padding-right: 5px; vertical-align: middle;">Progress</span>
   <img src="/quiz/image/progress-1.gif" title="Progress" alt="Progress" class="progressBar2">
   
  </div>

	<br>
  
  	<table class="QuestionTable BorderTop">
			
        <tbody><tr id="trQuestion1">      	
          <td class="LabelCell questionNo"><a name="Q1" id="Q1">&nbsp;</a></td>
          <td class="LabelCell questionName">
            Gender     
          </td>
          <td>
					
						<input type="hidden" name="intAnswer-1" id="intAnswer-1" value="">
						
								<img src="/quiz/image/radio-unchecked.gif" id="img1-1" onclick="javascript: radioSelect('1', '1', 'Male');" width="18" class="quizCheckbox"> <span onclick="radioSelect('1', '1', 'Male');" class="quizCheckboxLabel">Male</span>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<img src="/quiz/image/radio-unchecked.gif" id="img1-2" onclick="javascript: radioSelect('1', '2', 'Female');" width="18" class="quizCheckbox"> <span onclick="radioSelect('1', '2', 'Female');" class="quizCheckboxLabel">Female</span>
								
          </td>
        </tr>
        
        <tr id="trQuestion2">      	
          <td class="LabelCell questionNo"><a name="Q2" id="Q2">&nbsp;</a></td>
          <td class="LabelCell questionName">
            Age group (years)     
          </td>
          <td>
					
						<input type="hidden" name="intAnswer-2" id="intAnswer-2" value="">
						
								<img src="/quiz/image/radio-unchecked.gif" id="img2-186" onclick="javascript: radioSelect('2', '186', '< 2 - Not suitable for use in this age group'); disableQuiz(true);" width="18" class="quizCheckbox"> <span onclick="radioSelect('2', '186', '< 2 - Not suitable for use in this age group'); disableQuiz(true);" class="quizCheckboxLabel">&lt; 2 - Not suitable for use in this age group</span>
								<div id="divQuizDisable" style="display: none; color: #FF0000; font-weight: bold;">
                	Unfortunately you are unable to complete this quiz if you are under 2 years of age
                </div>
								<br><br>
								<img src="/quiz/image/radio-unchecked.gif" id="img2-185" onclick="javascript: radioSelect('2', '185', '2-4');" width="18" class="quizCheckbox"> <span onclick="radioSelect('2', '185', '2-4');" class="quizCheckboxLabel">2-4</span>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<img src="/quiz/image/radio-unchecked.gif" id="img2-4" onclick="javascript: radioSelect('2', '4', '5-8');" width="18" class="quizCheckbox"> <span onclick="radioSelect('2', '4', '5-8');" class="quizCheckboxLabel">5-8</span>
								<br><br>
								<img src="/quiz/image/radio-unchecked.gif" id="img2-153" onclick="javascript: radioSelect('2', '153', '9-15');" width="18" class="quizCheckbox"> <span onclick="radioSelect('2', '153', '9-15');" class="quizCheckboxLabel">9-15</span>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<img src="/quiz/image/radio-unchecked.gif" id="img2-183" onclick="javascript: radioSelect('2', '183', '16-17');" width="18" class="quizCheckbox"> <span onclick="radioSelect('2', '183', '16-17');" class="quizCheckboxLabel">16-17</span>
								<br><br>
								<img src="/quiz/image/radio-unchecked.gif" id="img2-184" onclick="javascript: radioSelect('2', '184', '18-24');" width="18" class="quizCheckbox"> <span onclick="radioSelect('2', '184', '18-24');" class="quizCheckboxLabel">18-24</span>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<img src="/quiz/image/radio-unchecked.gif" id="img2-155" onclick="javascript: radioSelect('2', '155', '25-34');" width="18" class="quizCheckbox"> <span onclick="radioSelect('2', '155', '25-34');" class="quizCheckboxLabel">25-34</span>
								<br><br>
								<img src="/quiz/image/radio-unchecked.gif" id="img2-156" onclick="javascript: radioSelect('2', '156', '35-44');" width="18" class="quizCheckbox"> <span onclick="radioSelect('2', '156', '35-44');" class="quizCheckboxLabel">35-44</span>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<img src="/quiz/image/radio-unchecked.gif" id="img2-157" onclick="javascript: radioSelect('2', '157', '45-54');" width="18" class="quizCheckbox"> <span onclick="radioSelect('2', '157', '45-54');" class="quizCheckboxLabel">45-54</span>
								<br><br>
								<img src="/quiz/image/radio-unchecked.gif" id="img2-158" onclick="javascript: radioSelect('2', '158', '55-64');" width="18" class="quizCheckbox"> <span onclick="radioSelect('2', '158', '55-64');" class="quizCheckboxLabel">55-64</span>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<img src="/quiz/image/radio-unchecked.gif" id="img2-159" onclick="javascript: radioSelect('2', '159', '65-74');" width="18" class="quizCheckbox"> <span onclick="radioSelect('2', '159', '65-74');" class="quizCheckboxLabel">65-74</span>
								<br><br>
								<img src="/quiz/image/radio-unchecked.gif" id="img2-160" onclick="javascript: radioSelect('2', '160', '75+');" width="18" class="quizCheckbox"> <span onclick="radioSelect('2', '160', '75+');" class="quizCheckboxLabel">75+</span>
								
          </td>
        </tr>
        
          <tr id="trQuestionConsent" class="ConsentRow" style="display: none;">      	
            <td colspan="3">
              <input type="hidden" name="intAnswer-Consent" id="intAnswer-Consent" value="">
              <div id="AdultConsent" style="display: none; padding-left: 50px;">
                We would like to use your anonymous Healthy Eating Quiz™ responses for research purposes.
                If you consent, your information will be stored securely and any identifiable information will be removed prior to analysis. Your information will remain confidential to the University of Newcastle researchers and will not be shared with any third party. Please refer to the Healthy Eating Quiz ™ Privacy Statement for more information.
                Your decision is entirely voluntary. If you would prefer that your data not be used for research purposes, it will not affect your use of the Healthy Eating Quiz ™. 
                <br><br>
                <strong>Please select one of the following:</strong>
                <br><br>
                <img src="/quiz/image/radio-unchecked.gif" id="imgAdultConsent-Yes" onclick="javascript: radioSelect('AdultConsent', 'Yes', '1');" width="18" class="quizCheckbox"> 
                <span onclick="radioSelect('AdultConsent', 'Yes', '1');" class="quizCheckboxLabel">I consent for my data to be de-identified and for this de-identified data to be used by the University of Newcastle for research purposes.</span>
                <br><br>
                <img src="/quiz/image/radio-unchecked.gif" id="imgAdultConsent-No" onclick="javascript: radioSelect('AdultConsent', 'No', '0');" width="18" class="quizCheckbox"> 
                <span onclick="radioSelect('AdultConsent', 'No', '0');" class="quizCheckboxLabel">I do not consent for my data to be used by the University of Newcastle for research purposes.</span>
              </div>
              <div id="MinorConsent" style="display: none; padding-left: 50px;">
                If you are a parent / carer / guardian who is providing consent on behalf of a minor (under the age of 18 years), you confirm that you have discussed the use of data with the minor.
                <br><br>
                <strong>Please select one of the following:</strong>
                <br><br>
                <img src="/quiz/image/radio-unchecked.gif" id="imgMinorConsent-Yes" onclick="javascript: radioSelect('MinorConsent', 'Yes', '1');" width="18" class="quizCheckbox"> 
                <span onclick="radioSelect('MinorConsent', 'Yes', '1');" class="quizCheckboxLabel">As a parent / carer / guardian of a minor (under the age of 18 years), I consent for their data to be de-identified and for this de-identified data to be used by the University of Newcastle for research purposes.</span>
                <br><br>
                <img src="/quiz/image/radio-unchecked.gif" id="imgMinorConsent-No" onclick="javascript: radioSelect('MinorConsent', 'No', '0');" width="18" class="quizCheckbox"> 
                <span onclick="radioSelect('MinorConsent', 'No', '0');" class="quizCheckboxLabel">As a parent / carer / guardian of a minor (under the age of 18 years), I do not consent for their data to be used by the University of Newcastle for research purposes.</span>
                <br><br>
                <span style="color: #F00;">If you are completing this quiz on behalf of your child, all questions from this point forward should be completed using your child’s information</span>
              </div>
            </td>
          </tr>
        
        <tr id="trQuestion3">      	
          <td class="LabelCell questionNo"><a name="Q3" id="Q3">&nbsp;</a></td>
          <td class="LabelCell questionName">
            Is this the first time you are taking this quiz?     
          </td>
          <td>
					
						<input type="hidden" name="intAnswer-3" id="intAnswer-3" value="">
						
								<img src="/quiz/image/radio-unchecked.gif" id="img3-5" onclick="javascript: radioSelect('3', '5', '1');" width="18" class="quizCheckbox"> <span onclick="radioSelect('3', '5', '1');" class="quizCheckboxLabel">Yes</span>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<img src="/quiz/image/radio-unchecked.gif" id="img3-6" onclick="javascript: radioSelect('3', '6', '0');" width="18" class="quizCheckbox"> <span onclick="radioSelect('3', '6', '0');" class="quizCheckboxLabel">No</span>
								
          </td>
        </tr>
        
        <tr id="trQuestion79">      	
          <td class="LabelCell questionNo"><a name="Q79" id="Q79">&nbsp;</a></td>
          <td class="LabelCell questionName">
            Are you a vegetarian?     
          </td>
          <td>
					
						<input type="hidden" name="intAnswer-79" id="intAnswer-79" value="">
						
								<img src="/quiz/image/radio-unchecked.gif" id="img79-177" onclick="javascript: radioSelect('79', '177', '1');" width="18" class="quizCheckbox"> <span onclick="radioSelect('79', '177', '1');" class="quizCheckboxLabel">Yes</span>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<img src="/quiz/image/radio-unchecked.gif" id="img79-178" onclick="javascript: radioSelect('79', '178', '0');" width="18" class="quizCheckbox"> <span onclick="radioSelect('79', '178', '0');" class="quizCheckboxLabel">No</span>
								
          </td>
        </tr>
        
        <tr id="trQuestion4">      	
          <td class="LabelCell questionNo"><a name="Q4" id="Q4">&nbsp;</a></td>
          <td class="LabelCell questionName">
            Height (Optional)     
          </td>
          <td>
					
						<input type="hidden" name="intAnswer-4" id="intAnswer-4" value="">
            <img src="/quiz/image/radio-unchecked.gif" id="img4-a" onclick="javascript: radioSelect('4', 'a', 'cm'); document.getElementById('divHeightCM').style.display = 'block'; document.getElementById('divHeightFT').style.display = 'none';" width="18" class="quizCheckbox"> <span onclick="radioSelect('4', 'a', 'cm');  document.getElementById('divHeightCM').style.display = 'block'; document.getElementById('divHeightFT').style.display = 'none';" class="quizCheckboxLabel">centimetres</span>
						&nbsp;&nbsp;<img src="/quiz/image/radio-unchecked.gif" id="img4-b" onclick="javascript: radioSelect('4', 'b', 'ft'); document.getElementById('divHeightCM').style.display = 'none'; document.getElementById('divHeightFT').style.display = 'block';" width="18" class="quizCheckbox"> <span onclick="radioSelect('4', 'b', 'ft');  document.getElementById('divHeightCM').style.display = 'none'; document.getElementById('divHeightFT').style.display = 'block';" class="quizCheckboxLabel">feet/inches</span>
            <div id="divHeightCM" style="display: none; padding-top: 10px;">
            	cm - <input type="text" name="strHeightCM" id="strHeightCM" value="" style="width: 50px;" maxlength="10">
            </div>
            <div id="divHeightFT" style="display: none; padding-top: 10px;">
            	ft - <input type="text" name="strHeightFT" id="strHeightFT" value="" style="width: 50px;" maxlength="10">
            	&nbsp;&nbsp;in - <input type="text" name="strHeightIN" id="strHeightIN" value="" style="width: 50px;" maxlength="10">
            </div>
						
          </td>
        </tr>
        
        <tr id="trQuestion5">      	
          <td class="LabelCell questionNo"><a name="Q5" id="Q5">&nbsp;</a></td>
          <td class="LabelCell questionName">
            Weight (Optional)     
          </td>
          <td>
					
						<input type="hidden" name="intAnswer-5" id="intAnswer-5" value="">
            <img src="/quiz/image/radio-unchecked.gif" id="img5-a" onclick="javascript: radioSelect('5', 'a', 'kg'); document.getElementById('divWeightKG').style.display = 'block'; document.getElementById('divWeightLB').style.display = 'none';" width="18" class="quizCheckbox"> <span onclick="radioSelect('5', 'a', 'kg');  document.getElementById('divWeightKG').style.display = 'block'; document.getElementById('divWeightLB').style.display = 'none';" class="quizCheckboxLabel">kilograms</span>
						&nbsp;&nbsp;<img src="/quiz/image/radio-unchecked.gif" id="img5-b" onclick="javascript: radioSelect('5', 'b', 'lb'); document.getElementById('divWeightKG').style.display = 'none'; document.getElementById('divWeightLB').style.display = 'block';" width="18" class="quizCheckbox"> <span onclick="radioSelect('5', 'b', 'lb');  document.getElementById('divWeightKG').style.display = 'none'; document.getElementById('divWeightLB').style.display = 'block';" class="quizCheckboxLabel">pounds</span>
            <div id="divWeightKG" style="display: none; padding-top: 10px;">
            	kg - <input type="text" name="strWeightKG" id="strWeightKG" value="" style="width: 50px;" maxlength="10">
            </div>
            <div id="divWeightLB" style="display: none; padding-top: 10px;">
            	lb - <input type="text" name="strWeightLB" id="strWeightLB" value="" style="width: 50px;" maxlength="10">
            </div>
            
          </td>
        </tr>
        
        <tr id="trQuestion77">      	
          <td class="LabelCell questionNo"><a name="Q77" id="Q77">&nbsp;</a></td>
          <td class="LabelCell questionName">
            How do you eat your main meal? (Optional)     
          </td>
          <td>
					
						<input type="hidden" name="intAnswer-77" id="intAnswer-77" value="">
						
								<img src="/quiz/image/radio-unchecked.gif" id="img77-173" onclick="javascript: radioSelect('77', '173', 'By yourself');" width="18" class="quizCheckbox"> <span onclick="radioSelect('77', '173', 'By yourself');" class="quizCheckboxLabel">By yourself</span>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<img src="/quiz/image/radio-unchecked.gif" id="img77-174" onclick="javascript: radioSelect('77', '174', 'With 1 other person');" width="18" class="quizCheckbox"> <span onclick="radioSelect('77', '174', 'With 1 other person');" class="quizCheckboxLabel">With 1 other person</span>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<img src="/quiz/image/radio-unchecked.gif" id="img77-175" onclick="javascript: radioSelect('77', '175', 'With 2 or more other people');" width="18" class="quizCheckbox"> <span onclick="radioSelect('77', '175', 'With 2 or more other people');" class="quizCheckboxLabel">With 2 or more other people</span>
								
          </td>
        </tr>
        
        <tr id="trQuestion84">      	
          <td class="LabelCell questionNo"><a name="Q84" id="Q84">&nbsp;</a></td>
          <td class="LabelCell questionName">
            Country you live in?     
          </td>
          <td>
					
            <select data-placeholder="-- Select Country --" class="" name="intAnswer-84" id="intAnswer-84" title="Country" style="width: 200px;">
                
             
                  
            </select>
						
          </td>
        </tr>
        
        <tr id="trQuestion78">      	
          <td class="LabelCell questionNo"><a name="Q78" id="Q78">&nbsp;</a></td>
          <td class="LabelCell questionName">
            Postcode you live at? (Optional)     
          </td>
          <td>
					
						<input type="text" name="intAnswer-78" id="intAnswer-78" value="" style="width: 75px;">
						
          </td>
        </tr>
        
    </tbody></table>
    <br><br>
    <table class="QuestionTable">
    	<tbody><tr>
      	<td class="leftCell">
        	
        </td>
      	<td class="middleCell">
        	
        </td>
       	<td class="rightCell">
        	<input type="hidden" name="strMandatory1" id="strMandatory1" value="1,2,Consent,3,79,84">
        	
            <input type="button" class="button" value="Next" id="btnNext1" onclick="if (sectionValidate('1')) { switchContentTab('2', ''); } ">
        	
        </td>
      </tr>
    </tbody>
    </table>
  <br>
</div>  
                        </div>
                        </form>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>			  
    </jsp:body>
</x:page>