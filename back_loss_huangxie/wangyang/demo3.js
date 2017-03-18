//window.onload = function(){
//	alert(1);
//}

;(function(window,undefined){
	function rule(_name,_if,_then){
		this["name"] = _name || this["name"]+(++ruleNUM);
		this["if"] =_if||this["if"];
		this["then"] =_then||this["then"] ;
	}
	var ruleNUM = 0;
	rule.prototype = { 
		"name":"rule",
		"if":[],
		"then":"",
		"addIF":function(_if){
			return addIF(this,_if);
		},
		"addTHEN":function(_then){
			return addTHEN(this,_then);
		}
	}
        
	Array.prototype.contains = function(item){
		for(var i=0,l=this.length;i<l;i++){
			if(item == this[i]){
				return true;
			}
		}
		return false;
	}	
	var rules = [];
	rules["addRULE"] = function(rule){
		this.push(rule);
	}
	function addRule(rule){
		rules.push(rule);
	} 
	function addIF(rule,_if){
		rule["if"] = _if;
		return rule;
	}
	function addTHEN(rule,_then){
		rule["then"] = _then;
		return rule;
	}
	
    //var tempRule = {"name":"rule1", "if":["animal has hair"],"then":"animal is mammal"}};
    //rules.push(tempRule);
	rules.addRULE(new rule("",["animal has hair"],"animal is mammal"));
	rules.addRULE(new rule("",["animal gives milk"],"animal is mammal"));
	rules.addRULE(new rule("",["animal has feathers"],"animal is bird"));
	rules.addRULE(new rule("",["animal flies","animal lays eggs"],"animal is bird"));
	rules.addRULE(new rule("",["animal eats meat"],"animal is carnivore"));
	rules.addRULE(new rule("",["animal has pointed teeth","animal has claws","animal has forword eyes"],"animal is carnivore"));
	rules.addRULE(new rule("",["animal is mammal","animal has hoofs"],"animal is ungulate"));
	rules.addRULE(new rule("",["animal is mammal","animal chews cud"],"animal is ungulate"));
	rules.addRULE(new rule("",["animal is mammal","animal is carnivore","animal has tawny color","animal has dark spots"],"animal is cheetah"));
	rules.addRULE(new rule("",["animal is mammal","animal is carnivore","animal has tawny color","animal has black stripes"],"animal is tiger"));
	rules.addRULE(new rule("",["animal is ungulate","animal has long neck","animal has long legs","animal has dark spots"],"animal is giraffe"));
	rules.addRULE(new rule("",["animal is ungulate","animal has black stripes"],"animal is zebra"));
	rules.addRULE(new rule("",["animal is bird","animal does not fly","animal has long neck","animal has long legs","animal is black and white"],"animal is ostrich"));
	rules.addRULE(new rule("",["animal is bird","animal does not fly","animal swims","animal is black and white"],"animal is penguin"));
	rules.addRULE(new rule("",["animal is bird","animal flies well"],"animal is albatross")); 
	//
	//rules is initted
	//
	//alert(rules[2]["if"][0]);
	//console.log(rules);
	
	
	function recall(fact){
		//fact in facts ? fact : false;
	    if(facts.contains(fact)) {
		return fact;
	    } 
	    return false;
	}
	function testIF(rule){
		//rule["if"][i] not in facts ? false:true;
		var is = true;
		for(var i=0,l=rule["if"].length;i <l;i++){
			if(!facts.contains(rule["if"][i])){ 
				is=false;
				break;
			}
		}
		return is;
	}
	function remember(_new){
		//_new in facts ? !1 : _new
		if(facts.contains(_new)) {
			return false; 
		}
		facts.unshift(_new);
		return _new;
	}
	function useThen(rule){
		var is = false;
		if(!facts.contains(rule["then"])){
			facts.push(rule["then"]);
			is = true;
		}
                //alert(rule["then"]);
		return is;
	}
	function tryRule(rule){
		// if is all in facts and then is not in facts
		return (testIF(rule)&&useThen(rule));
	}
	function stepForward(_rules){
		var tempIF,is = false;
		for(var i=0,l=_rules.length;i<l;i++){  
			if(tryRule(_rules[i])){
				// run tryRule if it return false 
				// this return true else return false
				is = true;
			}
		} 
		return is;
	}
	function deduce(_facts){
		// run stepForward until it return false
		var progress = false;
		while(true){
			if(stepForward(rules)){
				progress=true
			} else{
				return progress;
			}
		}
	}
	var facts = [];
	facts.push("animal has dark spots");
	facts.push("animal has tawny color");
	facts.push("animal eats meat");
	facts.push("animal has hair");
	
	deduce(facts);
	//
	  window.facts = facts;
	  window.rules = rules;
	//
	
	//console.log(facts)
	//console.log(rules)
	//for(var i=0,l=rules.length;i<l;i++){
  	//	var is = false;
  	//	is = rules[i]["if"].contains(facts[0]);
 	//	is = rules[i]["if"].contains(facts[1]);
  	//	is = rules[i]["if"].contains(facts[2]);
  	//	is = rules[i]["if"].contains(facts[3]);
  	//	is = rules[i]["if"].contains(facts[4]);
  	//	is&&console.log(rules[i]["then"]);
	//}
	
	console.log(facts);
	// maybe have some errors 
})(window)
