/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workinProgres.workinProgres.controlador;

import APP.Ciudad;
import APP.Guia;
import APP.PuntoInteres;
import APP.Tour;
import APP.UsuarioNoGuia;
import APP.Visita;
import BBDD.FachadaBBDD;
import BBDD.GestorBBDDPuntosInteres;
import BBDD.GestorBBDDciudad;
import BBDD.GestorBBDDguia;
import BBDD.GestorBBDDtour;
import BBDD.GestorBBDDusuario;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Miguel
 */
@Controller
//@RequestMapping("/base")
public class Controlador {
FachadaBBDD fbd = new FachadaBBDD();
GestorBBDDguia gbdguia = new GestorBBDDguia();
GestorBBDDusuario gbduser = new GestorBBDDusuario();
GestorBBDDciudad gbdciudad = new GestorBBDDciudad();
GestorBBDDtour gbdtour = new GestorBBDDtour();
GestorBBDDPuntosInteres gbdpi = new GestorBBDDPuntosInteres(); 

    
    @GetMapping("/crud")
    public String principal(){
    return "main";
    }
        
    @GetMapping("/altaguia")
    public String greetingForm(Model model) throws SQLException{
        model.addAttribute("g1", new Guia());
        model.addAttribute("periodos", gbdciudad.listarCiudad());
    return "altaGuia";
    }
    
    @PostMapping("/altaguia")
    public String greetingSubmit(@ModelAttribute Guia guia, Model model) { 
        String valorfinal = "main";
        fbd.altaGuia(guia);
        System.out.println(guia.getId_ciudadResidencia());
    return valorfinal; 
  }
    
    @GetMapping("/listarguias")
    public String listarGuias(Model model) throws SQLException{
        model.addAttribute("list", gbdguia.listarGuias()); 
    return "listarGuias";
    }
    
    @GetMapping("/borrarguia")
    public String borrarGuia (@RequestParam ("codguia") int id, Model model) throws SQLException{
        fbd.eliminarGuia(id);
        model.addAttribute("list", gbdguia.listarGuias());
    return "listarGuias";
    }

    @GetMapping("/modificarguia")
    public String modificarGuia (@RequestParam ("codguia") int id, Model model) throws SQLException{
        String valorfinal="modificarGuia";
        model.addAttribute("guia", gbdguia.consultarUnCliente(id));
    return valorfinal;
}

    @PostMapping("/modificarguia")
    public String modificarGuia (@ModelAttribute Guia guia, Model model) throws SQLException{
        String valorfinal="listarGuias";
        fbd.modificarGuia(guia);
        model.addAttribute("list", gbdguia.listarGuias());
    return valorfinal;
}
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    /*
    @GetMapping("/nuevavisita")
    public String nuevaVisita (@RequestParam ("codguia") int id, Model model) throws SQLException{
        String valorfinal="nuevavisitapaint";
        model.addAttribute("guia", gbdguia.consultarUnCliente(id));
    return valorfinal;
}

    @PostMapping("/nuevavisita")
    public String nuevaVisita (@ModelAttribute Guia guia, Model model) throws SQLException{
        String valorfinal="listarGuias";
        fbd.modificarGuia(guia);
        model.addAttribute("list", gbdguia.listarGuias());
    return valorfinal;
*/
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @GetMapping("/altausuario")
    public String greetingFormUser(Model model){
        model.addAttribute("u1", new UsuarioNoGuia()); 
    return "altaUsuarioNoGuia";
    }
    
    @PostMapping("/altausuario")
    public String greetingSubmitUser(@ModelAttribute UsuarioNoGuia user, Model model) { 
        String valorfinal = "main";
        fbd.altaUsuario(user);
    return valorfinal; 
    }
    
    @GetMapping("/listarusuarios")
    public String listarUsuarios(Model model) throws SQLException{
        model.addAttribute("list", gbduser.listarUsuarios()); 
    return "listarUsuarios";
    }
    
    @GetMapping("/borrarusuario")
    public String borrarUsuario (@RequestParam ("codusuario") int id, Model model) throws SQLException{
        fbd.eliminarUsuario(id);
        model.addAttribute("list", gbduser.listarUsuarios());
    return "listarUsuarios";
    }

    @GetMapping("/modificausuario")
    public String modificarUsuario (@RequestParam ("codusuario") int id, Model model) throws SQLException{
        String valorfinal="modificarUsuario";
        model.addAttribute("user", gbduser.consultarUnClienteNoGuia(id));
    return valorfinal;
}

    @PostMapping("/modificausuario")
    public String modificarUsuario(@ModelAttribute UsuarioNoGuia user, Model model) throws SQLException{
        String valorfinal="listarUsuarios";
        fbd.modificarusuario(user);
        model.addAttribute("list", gbduser.listarUsuarios());
    return valorfinal;
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @GetMapping("/altaciudad")
    public String greetingFormCiudad(Model model){
        model.addAttribute("c1", new Ciudad()); 
    return "altaCiudad";
    }
    
    @PostMapping("/altaciudad")
    public String greetingSubmitCiudad(@ModelAttribute Ciudad ciudad, Model model) { 
        String valorfinal = "main";
        fbd.altaCiudad(ciudad);
    return valorfinal; 
    }
    
    @GetMapping("/listarciudades")
    public String listarCiudades(Model model) throws SQLException{
        model.addAttribute("list", gbdciudad.listarCiudad()); 
    return "listarCiudades";
    }
    
    @GetMapping("/borrarciudad")
    public String borrarCiudad(@RequestParam ("codciudad") int id, Model model) throws SQLException{
        fbd.eliminarCiudad(id);
        model.addAttribute("list", gbdciudad.listarCiudad());
    return "listarCiudades";
    }

    @GetMapping("/modificarciudad")
    public String modificarCiudad (@RequestParam ("codciudad") int id, Model model) throws SQLException{
        String valorfinal="modificarCiudad";
        model.addAttribute("c1", gbdciudad.consultarUnaCiudad(id));
    return valorfinal;
}

    @PostMapping("/modificarciudad")
    public String modificarCiudad(@ModelAttribute Ciudad ciudad, Model model) throws SQLException{
        String valorfinal="listarCiudades";
        fbd.modificarCiudad(ciudad);
        model.addAttribute("list", gbdciudad.listarCiudad());
    return valorfinal;
    }
    
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    @GetMapping("/altatour")
    public String greetingFormTOUR(@RequestParam ("codguia") int id, Model model) throws SQLException{
        model.addAttribute("tour", new Tour()); 
        model.addAttribute("periodos", gbdciudad.listarCiudad());
        model.addAttribute("ideGuia", id); 
                
    return "altaTourIntermedio";
    }
    
    @PostMapping("/altatour")
    public String greetingSubmitTOUR( @ModelAttribute Tour tour, Model model) throws SQLException { 
        String valorfinal = "listarPuntInteres";
        fbd.altaTour(tour);
        model.addAttribute("list", gbdpi.obtenerPuntosDeInteres());

    return valorfinal; 
    }
    
    @GetMapping("/listartours")
    public String listaTours(Model model) throws SQLException{
        model.addAttribute("tour", new Tour()); 
        model.addAttribute("lista", gbdtour.listarTours()); 
                
    return "listarTours";
    }
    
    @GetMapping("/mostrarMapa")
    public String mostrarMApa(@RequestParam ("codtour") int id, Model model) throws SQLException{
        String mapaRuta = gbdtour.mostrarMapaRuta(id);
//        model.addAttribute("id", id); // agrega el id del tour al modelo
        model.addAttribute("mapaRuta", mapaRuta);        
    return "mostrarMapa";
    }
    
    
    //listar tours de un guia determinado posible opcion realizar tour para añadirse a la tabla de visitas
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    
         @GetMapping("/altapint")
    public String greetingPUNTOINTERES(Model model) throws SQLException{
        model.addAttribute("Pint", new PuntoInteres()); 
         model.addAttribute("periodos", gbdciudad.listarCiudad());
    return "altaPuntoInteres";
    }
    
    @PostMapping("/altapint")
    public String greetingPUNTOINTERES(PuntoInteres pi, Model model) throws SQLException { 
        String valorfinal = "main";
        fbd.altaPuntoInteres(pi);
    return valorfinal; 
}
    
    @GetMapping("/listarpint")
    public String listarPint(Model model) throws SQLException{
        model.addAttribute("list", gbdpi.obtenerPuntosDeInteres());
        return "listarPuntInteres";
    }

    @RequestMapping("/listarpinti")
    @PostMapping
    public String añadirPintaUnTour(@RequestParam("puntoId") int puntoId, 
                             @RequestParam("localizacion") String localizacion,
                             Model model) throws SQLException{
        System.out.println(puntoId );
        System.out.println(localizacion );
        gbdtour.addPointRuta(puntoId,localizacion);
        return "redirect:/listarpint"; // redirige de vuelta a la página listarPuntInteres después de añadir el punto
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}