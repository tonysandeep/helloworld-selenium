$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("FeatureList.feature");
formatter.feature({
  "line": 2,
  "name": "Hello World feature list",
  "description": "",
  "id": "hello-world-feature-list",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 6,
  "name": "Check SignIn",
  "description": "",
  "id": "hello-world-feature-list;check-signin",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "landing page is loaded",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "click sign in",
  "keyword": "And "
});
formatter.match({
  "location": "stepDef.landing_page_is_loaded()"
});
formatter.result({
  "duration": 44947623070,
  "status": "passed"
});
formatter.match({
  "location": "stepDef.click_sign_in()"
});
formatter.result({
  "duration": 104566958,
  "status": "passed"
});
formatter.after({
  "duration": 736244056,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "Check Sign Up",
  "description": "",
  "id": "hello-world-feature-list;check-sign-up",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "landing page is loaded",
  "keyword": "Given "
});
formatter.step({
  "line": 14,
  "name": "enter email address",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "click sign up",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDef.landing_page_is_loaded()"
});
formatter.result({
  "duration": 39065571505,
  "status": "passed"
});
formatter.match({
  "location": "stepDef.enter_email_address()"
});
formatter.result({
  "duration": 151001138,
  "status": "passed"
});
formatter.match({
  "location": "stepDef.click_sign_up()"
});
formatter.result({
  "duration": 607711643,
  "status": "passed"
});
formatter.after({
  "duration": 722756101,
  "status": "passed"
});
});