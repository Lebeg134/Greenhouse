!tok.
!took. 
!hok.
!hook.
  +!tok : hot(temperature) <- .send(master,tell,hot(temperature));.send(master,untell,ok(temperature));.send(master,untell,cold(temperature)); .wait(500);!tok.
 +!tok : ok(temperature) <- .send(master,tell,ok(temperature));.send(master,untell,cold(temperature));.send(master,untell,hot(temperature)); .wait(500);!tok.
  +!tok : cold(temperature) <- .send(master,tell,cold(temperature));.send(master,untell,ok(temperature));.send(master,untell,hot(temperature)); .wait(500);!tok.
  +!took : hot(outside) <- .send(master,tell,hot(temperature));.send(master,untell,ok(toutside));.send(master,untell,cold(outside)); .wait(500);!took.
 +!took : ok(toutside) <- .send(master,tell,ok(temperature));.send(master,untell,cold(outside));.send(master,untell,hot(outside)); .wait(500);!took.
  +!took : cold(outside) <- .send(master,tell,cold(temperature));.send(master,untell,ok(toutside));.send(master,untell,hot(outside)); .wait(500);!took.
  
    +!hok : damp(humidity) <- .send(master,tell,damp(humidity));.send(master,untell,ok(humidity));.send(master,untell,dry(humidity)); .wait(500);!hok.
    +!hok : ok(humidity) <- .send(master,tell,ok(humidity));.send(master,untell,dry(humidity));.send(master,untell,damp(humidity)); .wait(500);!hok.
	+!hok : dry(humidity) <- .send(master,tell,dry(humidity));.send(master,untell,ok(humidity));.send(master,untell,damp(humidity)); .wait(500);!hok.
    +!hook : damp(outside) <- .send(master,tell,damp(outside));.send(master,untell,ok(houtside));.send(master,untell,dry(outside)); .wait(500);!hook.
    +!hook : ok(houtside) <- .send(master,tell,ok(houtside));.send(master,untell,dry(outside));.send(master,untell,damp(outside)); .wait(500);!hook.
	+!hook : dry(outside) <- .send(master,tell,dry(outside));.send(master,untell,ok(houtside));.send(master,untell,damp(outside)); .wait(500);!hook.
