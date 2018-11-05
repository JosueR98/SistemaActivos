/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.funcionarios;

/**
 *
 * @author Josue R
 */
public class FuncionariosController {
    FuncionariosModel model;
    FuncionariosView view;

    public FuncionariosController(FuncionariosModel model, FuncionariosView view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
        model.getAgregarModel().setControladorPadre(this);
    }

    public FuncionariosModel getModel() {
        return model;
    }

    public FuncionariosView getView() {
        return view;
    }
    
}
