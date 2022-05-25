!tok.
!took. 
  +!tok : hot(temperature) <- .send(master,tell,hot(temperature));.send(master,untell,ok(temperature));.send(master,untell,cold(temperature)); .wait(500);!tok.
 +!tok : ok(temperature) <- .send(master,tell,ok(temperature));.send(master,untell,cold(temperature));.send(master,untell,hot(temperature)); .wait(500);!tok.
  +!tok : cold(temperature) <- .send(master,tell,cold(temperature));.send(master,untell,ok(temperature));.send(master,untell,hot(temperature)); .wait(500);!tok.
  +!took : hot(outside) <- .send(master,tell,hot(temperature));.send(master,untell,ok(toutside));.send(master,untell,cold(outside)); .wait(500);!took.
 +!took : ok(toutside) <- .send(master,tell,ok(temperature));.send(master,untell,cold(outside));.send(master,untell,hot(outside)); .wait(500);!took.
  +!took : cold(outside) <- .send(master,tell,cold(temperature));.send(master,untell,ok(toutside));.send(master,untell,hot(outside)); .wait(500);!took.
