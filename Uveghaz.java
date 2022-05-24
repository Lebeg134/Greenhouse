// Environment code for project ier_hazi.mas2j



import jason.asSyntax.*;

import jason.environment.*;

import jason.asSyntax.parser.*;



import java.util.logging.*;



public class Uveghaz extends Environment {



	/*Literal hot = Literal.parserLiteral("hot(temperature)");
	Literal okt = Literal.parserLiteral("ok(temperature)");
	Literal cold = Literal.parserLiteral("cold(temperature)");
	int temperature = 20;
	
	Literal hoto = Literal.parserLiteral("hot(outside)");
	Literal okto = Literal.parserLiteral("ok(temperature outside)");
	Literal coldo = Literal.parserLiteral("cold(outside)");
	int outtemperature = 30;
	
	Literal damp = Literal.parserLiteral("damp(humidity)");
	Literal okh = Literal.parserLiteral("ok(humidity)");
	Literal dry = Literal.parserLiteral("dry(humidity)");
	int humidity = 70;
	
	Literal dampo = Literal.parserLiteral("damp(outside)");
	Literal okho = Literal.parserLiteral("ok(humidity outside)");
	Literal dryo = Literal.parserLiteral("dry(outside)");
	int outhumidity = 20;
	*/
	Literal wets = Literal.parseLiteral("wet(soil)");
	Literal oks = Literal.parseLiteral("ok(soil)");
	Literal drys = Literal.parseLiteral("dry(soil)");
	int soilwetness = 20;
	/*
	Literal bright = Literal.parserLiteral("bright(light)");
	Literal okl = Literal.parserLiteral("ok(light)");
	Literal dark = Literal.parserLiteral("dark(light)");
	int brightness= 10;
	
	Literal brighto = Literal.parserLiteral("bright(outside)");
	Literal oklo = Literal.parserLiteral("ok(light outside)");
	Literal darko = Literal.parserLiteral("dark(outside)");
	int outbrightness=12;
	
	Literal fert = Literal.parserLiteral("fertilized(soil)");
	Literal nfert = Literal.parserLiteral("~fertilized(soil)");
	int fert = 13;*/
	
	
    /** Called before the MAS execution with the args informed in .mas2j */

    @Override

    public void init(String[] args) {

        addPercept(drys);
    }



    @Override

    public boolean executeAction(String agName, Structure action) {

         System.out.println("Agent "+agName+" is doing "+action);
		  clearPercepts();
        if (action.getFunctor().equals("wet")) { 
             soilwetness++;
        }
		if(soilwetness<=25){
			addPercept(drys);
		}
		if(soilwetness>25 && soilwetness < 30){
			 System.out.println("xdd");
			addPercept(oks);
		}
		if(soilwetness<=30){
			addPercept(wets);
		}
		informAgsEnvironmentChanged();
        return true;
    }



    /** Called before the end of MAS execution */

    @Override

    public void stop() {

        super.stop();

    }

}


