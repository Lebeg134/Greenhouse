!fok.
!ok. 
  +!fok : ~fertilized(soil) <- .send(master,tell,~fertilized(soil));.send(master,untell,fertilized(soil)); .wait(500);!fok.
  +!fok : fertilized(soil) <- .send(master,tell,fertilized(soil));.send(master,untell,~fertilized(soil)); .wait(500);!fok. 
  +!ok : dry(soil) <- .send(master,tell,dry(soil));.send(master,untell,ok(soil));.send(master,untell,wet(soil)); .wait(500);!ok.
  +!ok : ok(soil) <- .send(master,tell,ok(soil));.send(master,untell,dry(soil));.send(master,untell,wet(soil)); .wait(500);!ok.
  +!ok : wet(soil) <- .send(master,tell,wet(soil));.send(master,untell,dry(soil));.send(master,untell,ok(soil)); .wait(500);!ok.
  //ok a célja ezt ugy erheti el ha attol fuggoen milyen a fold a masternek kuldi mit kell csinalni es utana megint ez elsz a kuldetese


