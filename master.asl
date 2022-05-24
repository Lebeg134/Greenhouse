!okl.
!oks.
!okf.
 +!okl : dark(light)[source(fenyerzekelo)] & ok(outside)[source(fenyerzekelo)] <- .send(ablak_sotetito,achieve,ok(light)); .wait(500);!okl.
 +!okl : dark(light)[source(fenyerzekelo)] & dark(outside)[source(fenyerzekelo)] <- .send(vilagitas,achieve,ok(light)); .wait(500);!okl.
  +!okl : bright(light)[source(fenyerzekelo)] & ok(outside)[source(fenyerzekelo)] <- .send(vilagitas,achieve,dark(light)); .wait(500);!okl.
  +!okl : ok(light)  <- .print("jo a vilagossag"); .wait(500);!okl.
  +!okl   <-  .wait(500);!okl.
 +!oks : dry(soil)[source(nedv_tap_mero)] <- .send(ontozo,achieve,ok(soil)); .wait(500);!oks.
  +!oks : not dry(soil)[source(nedv_tap_mero)] <- .print("jo a nedvesseg"); .wait(500);!oks.
 +!okf : fertilized(soil)[source(nedv_tap_mero)] <- .print("jo a tragya"); .wait(500);!okf.
  +!okf : not fertilized(soil)[source(nedv_tap_mero)] <- .send(tragyazo,achieve,fertilized(soil)); .wait(500);!okf.
// +!ok : dry(soil)[source(nedv_tap_mero)] <- .send(ontozo,achieve,ok(soil)); .wait(500);!ok.
 
