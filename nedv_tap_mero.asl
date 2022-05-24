!ok. 
  +!ok : dry(soil) <- .send(master,achieve,wet(soil)); .wait(500);!ok.
  +!ok : ok(soil) <- .send(master,tell,ok(soil)); .wait(500);!ok.
  +!ok : wet(soil) <- .send(master,tell,dry(soil)); .wait(500);!ok.
  //ok a célja ezt ugy erheti el ha attol fuggoen milyen a fold a masternek kuldi mit kell csinalni es utana megint ez elsz a kuldetese


