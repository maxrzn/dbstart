package de.hbrs.ia.code;

import de.hbrs.ia.model.SalesMan;
import org.springframework.web.bind.annotation.*;
import de.hbrs.ia.code.ManagePersonal.*;

@RestController
@RequestMapping(value = "/salesmen")
public class SalesmenController {
    ManagePersonal mp = new ManagePersonal();

    @RequestMapping(value = "/hallo", method = RequestMethod.GET)
    public String hallo(){
        return "hallo";
    }

    @RequestMapping( value = "{sid}", method = RequestMethod.GET)
    public String getSalesmen(@PathVariable Integer sid) {
            return mp.readSalesMan(sid).toString();
    }

    @PostMapping
    public void createSalesman(@RequestBody(required = true) SalesMan salesman) {
        mp.createSalesMan(salesman);
    }

}
