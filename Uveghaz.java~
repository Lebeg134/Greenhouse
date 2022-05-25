// Environment code for project ier_hazi.mas2j



import jason.asSyntax.*;

import jason.environment.*;

import jason.asSyntax.parser.*;



import java.util.logging.*;



public class Uveghaz extends Environment {



	Literal hot = Literal.parseLiteral("hot(temperature)");
	Literal okt = Literal.parseLiteral("ok(temperature)");
	Literal cold = Literal.parseLiteral("cold(temperature)");
	int temperature = 20;
	
	Literal hoto = Literal.parseLiteral("hot(outside)");
	Literal okto = Literal.parseLiteral("ok(toutside)");
	Literal coldo = Literal.parseLiteral("cold(outside)");
	int outtemperature = 33;
	/*
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
	
	Literal bright = Literal.parseLiteral("bright(light)");
	Literal okl = Literal.parseLiteral("ok(light)");
	Literal dark = Literal.parseLiteral("dark(light)");
	int brightness= 10;
	
	Literal brighto = Literal.parseLiteral("bright(outside)");
	Literal oklo = Literal.parseLiteral("ok(outside)");
	Literal darko = Literal.parseLiteral("dark(outside)");
	int outbrightness=17;
	
	Literal fert = Literal.parseLiteral("fertilized(soil)");
	Literal nfert = Literal.parseLiteral("~fertilized(soil)");
	int fertilization = 13;
	
	
    /** Called before the MAS execution with the args informed in .mas2j */

    @Override

    public void init(String[] args) {
		addPercept(nfert);
        addPercept(drys);
		addPercept(dark);
		addPercept(oklo);
		addPercept(cold);
		addPercept(okto);
    }



    @Override

    public boolean executeAction(String agName, Structure action) {

         System.out.println("Agent "+agName+" is doing "+action);
		  clearPercepts();
        if (action.getFunctor().equals("wet")) { 
             soilwetness++;
        }
		 if (action.getFunctor().equals("fert")) { 
             fertilization++;
        }
		if (action.getFunctor().equals("lightup")) { 
             brightness++;
        }
		if (action.getFunctor().equals("lightdown")) { 
             brightness--;
        }
		if (action.getFunctor().equals("windowopen")) { 
             brightness=brightness +outbrightness;
        }
		if (action.getFunctor().equals("windowclose")) { 
             brightness=brightness -outbrightness;
        }
		 if (action.getFunctor().equals("hot")) { 
             temperature++;
        }
		 if (action.getFunctor().equals("cold")) { 
             temperature--;
        }
		 if (action.getFunctor().equals("open")) { 
             temperature=outtemperature;
        }
		
		
		if(temperature<=30){
			addPercept(cold);
		}
		if(temperature>30 && temperature<35){
			 System.out.println("xdfssfsfsd");
			addPercept(okt);
		}
		if(temperature>=35){
			addPercept(hot);
		}
		
		if(outtemperature<=30){
			addPercept(coldo);
		}
		if(outtemperature>30 && outtemperature<35){
			addPercept(okto);
		}
		if(outtemperature>=35){
			addPercept(hoto);
		}
		
		if(brightness<=15){
			addPercept(dark);
		}
		if(brightness>15 && brightness<20){
			addPercept(okl);
		}
		if(brightness>=20){
			addPercept(bright);
		}
		
		if(outbrightness<=15){
			addPercept(darko);
		}
		if(outbrightness>15 && outbrightness<20){
			addPercept(oklo);
		}
		if(outbrightness>=20){
			addPercept(brighto);
		}
		
		if(fertilization<=15){
			addPercept(nfert);
		}
		if(fertilization>15){
			addPercept(fert);
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


