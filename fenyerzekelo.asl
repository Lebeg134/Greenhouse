!fok.
!fook.
  +!fok : bright(light) <- .send(master,tell,bright(light));.send(master,untell,ok(light));.send(master,untell,dark(light)); .wait(500);!fok.
  +!fok : ok(light) <- .send(master,tell,ok(light));.send(master,untell,dark(light));.send(master,untell,bright(light)); .wait(500);!fok. 
  +!fok : dark(light) <- .send(master,tell,dark(light));.send(master,untell,ok(light));.send(master,untell,bright(light)); .wait(500);!fok.
  +!fook : bright(outside) <- .send(master,tell,bright(outside));.send(master,untell,ok(outside));.send(master,untell,dark(outside)); .wait(500);!fook. 
  +!fook : ok(outside) <- .send(master,tell,ok(outside));.send(master,untell,bright(outside));.send(master,untell,dark(outside)); .wait(500);!fook. 
  +!fook : dark(outside) <- .send(master,tell,dark(outside));.send(master,untell,ok(outside));.send(master,untell,bright(outside)); .wait(500);!fook. 
