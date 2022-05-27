// Environment code for project ier_hazi.mas2j



import jason.asSyntax.*;

import jason.environment.*;

import jason.asSyntax.parser.*;



import java.util.logging.*;



public class Uveghaz extends Environment {
	public static Uveghaz Instance;
	public Plant plant;
	public Uveghaz(){
		if (Instance == null)
			Instance = this;
		plant = new Plant(
				15,25,
				15,25,
				30,35,
				15, 20,
				15,
				25,30
		);
	}

	public void setPlant(Plant plant) {
		this.plant = plant;
	}

	Literal hot = Literal.parseLiteral("hot(temperature)");
	Literal okt = Literal.parseLiteral("ok(temperature)");
	Literal cold = Literal.parseLiteral("cold(temperature)");
	int temperature = 20;
	
	Literal hoto = Literal.parseLiteral("hot(outside)");
	Literal okto = Literal.parseLiteral("ok(toutside)");
	Literal coldo = Literal.parseLiteral("cold(outside)");
	int outtemperature = 33;
	
	Literal damp = Literal.parseLiteral("damp(humidity)");
	Literal okh = Literal.parseLiteral("ok(humidity)");
	Literal dry = Literal.parseLiteral("dry(humidity)");
	int humidity = 70;
	
	Literal dampo = Literal.parseLiteral("damp(outside)");
	Literal okho = Literal.parseLiteral("ok(houtside)");
	Literal dryo = Literal.parseLiteral("dry(outside)");
	int outhumidity = 20;
	
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
	boolean windowopen=false;
	
    /** Called before the MAS execution with the args informed in .mas2j */

    @Override

    public void init(String[] args) {
		addPercept(nfert);
        addPercept(drys);
		addPercept(dark);
		addPercept(oklo);
		addPercept(cold);
		addPercept(okto);
		addPercept(damp);
		addPercept(okho);
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
             windowopen =true;
        }
		if (action.getFunctor().equals("windowclose")) { 
             windowopen=false;
        }
		 if (action.getFunctor().equals("hot")) { 
             temperature++;
        }
		 if (action.getFunctor().equals("cold")) { 
             temperature--;
        }
		 if (action.getFunctor().equals("open")) { 
             temperature=outtemperature;
			 humidity=outhumidity;
        }
		if (action.getFunctor().equals("dehumid")) { 
             humidity--;
        }
		if (action.getFunctor().equals("humid")) { 
             humidity++;
        }
		
		if(humidity<=plant.dry){
			addPercept(dry);
		}
		if(humidity>plant.dry && humidity<plant.damp){
			addPercept(okh);
		}
		if(humidity>=plant.damp){
			addPercept(damp);
		}
		if(outhumidity<=plant.dryhm){
			addPercept(dryo);
		}
		if(outhumidity>plant.dryhm && outhumidity<plant.damphm){
			addPercept(okho);
		}
		if(outhumidity>=plant.damphm){
			addPercept(dampo);
		}
		
		if(temperature<=plant.cold){
			addPercept(cold);
		}
		if(temperature>plant.cold && temperature<plant.hot){
			addPercept(okt);
		}
		if(temperature>=plant.hot){
			addPercept(hot);
		}
		
		if(outtemperature<=plant.cold){
			addPercept(coldo);
		}
		if(outtemperature>plant.cold && outtemperature<plant.hot){
			addPercept(okto);
		}
		if(outtemperature>=plant.hot){
			addPercept(hoto);
		}
		if(windowopen){
		if(brightness+outbrightness<=plant.dark){
			addPercept(dark);
		}
		if(brightness+outbrightness>plant.dark && brightness+outbrightness< plant.bright){
			addPercept(okl);
		}
		if(brightness+outbrightness>= plant.bright){
			addPercept(bright);
		}}
		else{
			if(brightness<=plant.dark){
			addPercept(dark);
		}
		if(brightness>plant.dark && brightness<plant.bright){
			addPercept(okl);
		}
		if(brightness>=plant.bright){
			addPercept(bright);
		}
		}
		
		if(outbrightness<=plant.dark){
			addPercept(darko);
		}
		if(outbrightness>plant.dark && outbrightness<plant.bright){
			addPercept(oklo);
		}
		if(outbrightness>=plant.bright){
			addPercept(brighto);
		}
		
		if(fertilization<=plant.fertilization){
			addPercept(nfert);
		}
		if(fertilization>plant.fertilization){
			addPercept(fert);
		}
		
		
		if(soilwetness<=plant.drys){
			addPercept(drys);
		}
		if(soilwetness>plant.drys && soilwetness < plant.wets){
			addPercept(oks);
		}
		if(soilwetness<=plant.wets){
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


