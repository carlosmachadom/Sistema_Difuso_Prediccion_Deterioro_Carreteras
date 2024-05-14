/**
 * 
 */
package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 * 
 */
@SuppressWarnings("serial")
public class FormularioUnoTipoCarretera extends JPanel {	
	private JPanel contenedorFormulario;	
	private JComboBox<String> tipoCarretera;
	private JComboBox<String> materialCarretera;
	private JTextField humedadSuelo;
	private JButton botonSiguiente;
	private JButton botonCancelar;
	
	public FormularioUnoTipoCarretera() {
		setBorder(new EmptyBorder(0, 0, 0, 0));
        setPreferredSize(new Dimension(1440, 960));
        setLayout(new BorderLayout());
        inicializarComponentes();
        setVisible(true);
	}
	
	public void inicializarComponentes() {
		insertarCabecera();
		insertarContenidoPrincipal();
		insertarPieDePagina();
	}
	
	public void insertarCabecera() {
		JPanel header = new JPanel();
		header.setBackground(new Color(242, 97, 63));
		header.setBorder(new EmptyBorder(12,12,12,12));
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
    	
		Font fuente = new Font("Arial", Font.BOLD, 24);
		Color colorFuente = new Color(252, 255, 218);
		Border margen = BorderFactory.createEmptyBorder(0, 40, 0, 40);
		
    	JLabel titulo = new JLabel("Pavement Forecast");
    	titulo.setFont(fuente);
    	titulo.setBorder(margen);
    	titulo.setForeground(colorFuente);
    	
    	JLabel stepper = new JLabel("Paso 1 de 3");
    	stepper.setFont(fuente);
    	stepper.setBorder(margen);
    	stepper.setForeground(colorFuente);
    	
    	header.add(titulo);
    	header.add(Box.createHorizontalGlue());
    	header.add(stepper);
    	
    	add(header, BorderLayout.NORTH);
	}
	
	public void insertarContenidoPrincipal() {
		contenedorFormulario = new JPanel();
		contenedorFormulario.setLayout(new BoxLayout(contenedorFormulario, BoxLayout.Y_AXIS));
		contenedorFormulario.setBackground(new Color(0,0,0,70));
		contenedorFormulario.setBorder(new EmptyBorder(40,12,12,40));
		
		insertarTitulo();
		insertarCamposFormulario();
		insertarBotones();
		
		add(contenedorFormulario, BorderLayout.CENTER);
	}
	
	public void insertarTitulo() {
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new BoxLayout(panelTitulo, BoxLayout.X_AXIS));
		panelTitulo.setOpaque(false);
		
		Font fuente = new Font("Arial", Font.BOLD, 64);
		Color colorFuente = new Color(242, 97, 63);
		Border margen = BorderFactory.createEmptyBorder(0, 40, 0, 40);
		
    	JLabel titulo = new JLabel("Datos generales Carretera");
    	titulo.setFont(fuente);
    	titulo.setForeground(colorFuente);
    	titulo.setBorder(margen);
    	
    	if(contenedorFormulario != null) {
    		panelTitulo.add(titulo);
    		panelTitulo.add(Box.createHorizontalGlue());
    		contenedorFormulario.add(panelTitulo);
    	}
	}		
	
	public void insertarCamposFormulario() {		
		JPanel seccion = new JPanel();
		seccion.setLayout(new FlowLayout(FlowLayout.LEADING));
		seccion.setBackground(new Color(0,0,0,0));
		seccion.setBorder(new EmptyBorder(0,40,40,0));
		
		JPanel container = new JPanel();
		container.setBackground(new Color(0,0,0,0));
		container.setPreferredSize(new Dimension(1000, 110));
		container.setBorder(new EmptyBorder(0,0,0,0));
		
		JPanel contenedorCampos = new JPanel();
		contenedorCampos.setLayout(new FlowLayout(FlowLayout.LEFT));
		contenedorCampos.setBackground(new Color(0,0,0,0));
		contenedorCampos.setBorder(new EmptyBorder(20,0,20,40));
		contenedorCampos.setMaximumSize(new Dimension(this.getPreferredSize().width, 110));
		contenedorCampos.setAlignmentX(Component.RIGHT_ALIGNMENT);
		
		Font fuente = new Font("Arial", Font.BOLD, 24);
		Color colorFuente = new Color(252, 255, 218);
		
		JPanel contenedorCampoUno = new JPanel();
		contenedorCampoUno.setLayout(new GridLayout(2, 1, 10, 10));
		contenedorCampoUno.setBackground(new Color(0,0,0,0));
        JLabel tituloCampoUno = new JLabel("Tipo de carretera");
        tituloCampoUno.setFont(fuente);
        tituloCampoUno.setForeground(colorFuente);
		String[] tiposCarretera = {"Primaria", "Secundaria", "Terciaria"};
        tipoCarretera = new JComboBox<>(tiposCarretera);
        tipoCarretera.setPreferredSize(new Dimension(300, 30));
        contenedorCampoUno.add(tituloCampoUno);
        contenedorCampoUno.add(tipoCarretera);
				
		
		JPanel contenedorCampoDos = new JPanel();
		contenedorCampoDos.setLayout(new GridLayout(2, 1, 10, 10));
		contenedorCampoDos.setBackground(new Color(0,0,0,0));
		JLabel tituloCampoDos = new JLabel("Materiales de carretera");
		tituloCampoDos.setFont(fuente);
		tituloCampoDos.setForeground(colorFuente);
		String[] materialesCarretera = {"Metamorficos", "Sedimentarios", "Igneos"};
        materialCarretera = new JComboBox<>(materialesCarretera);
        materialCarretera.setPreferredSize(new Dimension(300, 30));
        contenedorCampoDos.add(tituloCampoDos);
        contenedorCampoDos.add(materialCarretera);
        
        JPanel contenedorCampoTres = new JPanel();
        contenedorCampoTres.setLayout(new GridLayout(2, 1, 10, 10));
        contenedorCampoTres.setBackground(new Color(0,0,0,0));
		JLabel tituloCampoTres = new JLabel("Humedad suelo (0% - 100%)");
		tituloCampoTres.setFont(fuente);
		tituloCampoTres.setForeground(colorFuente);
        humedadSuelo = new JTextField();
        humedadSuelo.setPreferredSize(new Dimension(300, 30));
        contenedorCampoTres.add(tituloCampoTres);
        contenedorCampoTres.add(humedadSuelo);        
        
        contenedorCampos.add(contenedorCampoUno);
        contenedorCampos.add(Box.createHorizontalStrut(8));
        contenedorCampos.add(contenedorCampoDos);
        contenedorCampos.add(Box.createHorizontalStrut(8));
        contenedorCampos.add(contenedorCampoTres);
        
        
        container.add(contenedorCampos);
        seccion.add(container);
        
        if(contenedorFormulario != null) {
    		contenedorFormulario.add(seccion);
    	}
	}

	public void insertarBotones() {
		JPanel contenedor = new JPanel(new BorderLayout());
		contenedor.setBackground(new Color(0,0,200,0));
		
		JPanel contenedorBotones = new JPanel(new FlowLayout(FlowLayout.LEFT));
        contenedorBotones.setBackground(new Color(255, 255, 255, 0));
        contenedorBotones.setBorder(new EmptyBorder(0, 40, 40, 40));


        botonCancelar = new JButton("Cancelar");
        botonCancelar.setBackground(new Color(252, 255, 218));
        botonCancelar.setFocusPainted(false);
        botonCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonCancelar.setBorder(new EmptyBorder(12, 16, 12, 16));
        botonCancelar.setMargin(new Insets(10, 20, 10, 20));
        Font fontBotonInformacion = new Font("Arial", Font.BOLD, 24);
        botonCancelar.setFont(fontBotonInformacion);
        botonCancelar.setForeground(new Color(72, 30, 20));
        botonCancelar.setActionCommand("Cancelar");
        
        botonSiguiente = new JButton("Siguiente");
        botonSiguiente.setBackground(new Color(242, 97, 63));
        botonSiguiente.setFocusPainted(false);
        botonSiguiente.setCursor(new Cursor(Cursor.HAND_CURSOR));
        botonSiguiente.setBorder(new EmptyBorder(12, 16, 12, 16));
        botonSiguiente.setMargin(new Insets(10, 20, 10, 20));
        Font fontBotonInicio = new Font("Arial", Font.BOLD, 24);
        botonSiguiente.setFont(fontBotonInicio);
        botonSiguiente.setForeground(new Color(252, 255, 218));
        botonSiguiente.setActionCommand("Siguiente_formulario_uno");

        contenedorBotones.add(botonCancelar);
        contenedorBotones.add(Box.createHorizontalStrut(16));
        contenedorBotones.add(botonSiguiente);
        
        contenedor.add(contenedorBotones, BorderLayout.NORTH);
        
        if(contenedorFormulario != null) {
    		contenedorFormulario.add(contenedor);
    	}
	}
	
	/**
     * Inserta el pie de página de la aplicación en la parte inferior del layout principal.
     * Se presenta la información de proyecto de la Universidad el Bosque.
     */
    public void insertarPieDePagina() {
    	JPanel piePagina = new JPanel();
    	piePagina.setBackground(new Color(242, 97, 63));
    	piePagina.setBorder(new EmptyBorder(12,12,12,12));
    	
    	JLabel textoPiePagina = new JLabel("Universidad el Bosque. 2024");
    	Font fontTextoPiePagina = new Font("Arial", Font.BOLD, 18);
    	textoPiePagina.setFont(fontTextoPiePagina);
    	textoPiePagina.setForeground(new Color(252, 255, 218));
    	
    	piePagina.add(textoPiePagina);
    	
    	add(piePagina, BorderLayout.SOUTH);
    }
	
	/**
     * Override del método paint para dibujar una imagen de fondo en el panel.
     * 
     * @param g El objeto Graphics utilizado para dibujar
     */
    @Override
    public void paint(Graphics g) {
        ImageIcon imagenFondo = new ImageIcon("src\\images\\Fondo_formulario_uno.png");
        g.drawImage(imagenFondo.getImage(), 0, 0, getWidth(), getHeight(), this); // Dibuja la imagen de fondo

        setOpaque(false); // Hace el panel transparente
        super.paint(g); // Llama al método paint de la superclase JPanel
    }

	public JComboBox<String> getTipoCarretera() {
		return tipoCarretera;
	}

	public JComboBox<String> getMaterialCarretera() {
		return materialCarretera;
	}

	public JTextField getHumedadSuelo() {
		return humedadSuelo;
	}
	
	public JButton getBotonSiguiente() {
		return botonSiguiente;
	}

	public JButton getBotonCancelar() {
		return botonCancelar;
	}
	
}
