!okl.
!oks.
!okf.
!okt.
!okh.

 +!okh : damp(humidity)[source(ho_para_mero)] & ok(houtside)[source(ho_para_mero)]  <- .send(nyilaszaro,achieve,hot(temperature)); .wait(500);!okh.//hot == open
  +!okh : damp(humidity)[source(ho_para_mero)] & not ok(houtside)[source(ho_para_mero)]  <- .send(klima,achieve,ok(humidity)); .wait(500);!okh.
+!okh : dry(humidity)[source(ho_para_mero)] & not ok(houtside)[source(ho_para_mero)] <- .send(parologtato,achieve,ok(humidity)); .wait(500);!okh.
+!okh : dry(humidity)[source(ho_para_mero)] & ok(houtside)[source(ho_para_mero)] <- .send(nyilaszaro,achieve,hot(temperature)); .wait(500);!okh.
  +!okh : ok(humidity)  <- .print("jo a paratartalom"); .wait(500);!okh.
   +!okh   <-  .wait(500);!okh.
  
 +!okt : hot(temperature)[source(ho_para_mero)] & ok(toutside)[source(ho_para_mero)]  <- .send(nyilaszaro,achieve,hot(temperature)); .wait(500);!okt.//hot == open
+!okt : hot(temperature)[source(ho_para_mero)] & not ok(toutside)[source(ho_para_mero)] <- .send(klima,achieve,cold(temperature)); .wait(500);!okt.
 +!okt : cold(temperature)[source(ho_para_mero)] & ok(toutside)[source(ho_para_mero)] <- .send(nyilaszaro,achieve,hot(temperature)); .wait(500);!okt.//cold==close
+!okt : cold(temperature)[source(ho_para_mero)] & not ok(toutside)[source(ho_para_mero)] <- .send(klima,achieve,hot(temperature)); .wait(500);!okt.
  +!okt : ok(temperature)  <- .print("jo a homerseklet"); .wait(500);!okt.
  
 +!okl : dark(light)[source(fenyerzekelo)] & ok(outside)[source(fenyerzekelo)] & window(close) <- .send(ablak_sotetito,achieve,ok(light)); .wait(500);!okl.
 +!okl : dark(light)[source(fenyerzekelo)] & dark(outside)[source(fenyerzekelo)] <- .send(vilagitas,achieve,ok(light)); .wait(500);!okl.
  +!okl : bright(light)[source(fenyerzekelo)] & bright(outside)[source(fenyerzekelo)] & window(open)  <- .send(ablak_sotetito,achieve,dark(light)); .wait(500);!okl.
   +!okl : bright(light)[source(fenyerzekelo)] & ok(outside)[source(fenyerzekelo)] <- .send(vilagitas,achieve,dark(light)); .wait(500);!okl.
  +!okl : ok(light)  <- .print("jo a vilagossag"); .wait(500);!okl.
  +!okl   <-  .wait(500);!okl.
  
 +!oks : dry(soil)[source(nedv_tap_mero)] <- .send(ontozo,achieve,ok(soil)); .wait(500);!oks.
  +!oks : not dry(soil)[source(nedv_tap_mero)] <- .print("jo a nedvesseg"); .wait(500);!oks.
  
 +!okf : fertilized(soil)[source(nedv_tap_mero)] <- .print("jo a tragya"); .wait(500);!okf.
  +!okf : not fertilized(soil)[source(nedv_tap_mero)] <- .send(tragyazo,achieve,fertilized(soil)); .wait(500);!okf.

 
