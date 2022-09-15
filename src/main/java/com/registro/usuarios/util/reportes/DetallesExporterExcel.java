	package com.registro.usuarios.util.reportes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.registro.usuarios.detalles_producto.Detalles_producto;
public class DetallesExporterExcel {

	private XSSFWorkbook libro;
	private XSSFSheet hoja;

	private List<Detalles_producto> listaDetalles_producto;

	public DetallesExporterExcel(List<Detalles_producto> listaDetalles_producto) {
		this.listaDetalles_producto = listaDetalles_producto;
		libro = new XSSFWorkbook();
		hoja = libro.createSheet("Detalles_Productos");
	}

	private void escribirCabeceraDeTabla() {
		
		Row fila = hoja.createRow(0);
		
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setBold(true);
		fuente.setFontHeight(16);
		estilo.setFont(fuente);
		
		Cell celda = fila.createCell(0);
		celda.setCellValue("ID");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(1);
		celda.setCellValue("Categoria");
		celda.setCellStyle(estilo);
	}
	
	private void escribirDatosDeLaTabla() {
		int numeroFilas = 1;
		
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setFontHeight(14);
		estilo.setFont(fuente);
		
		for(Detalles_producto detalles_producto : listaDetalles_producto) {
			Row fila = hoja.createRow(numeroFilas ++);
			
			Cell celda = fila.createCell(0);
			celda.setCellValue(detalles_producto.getId());
			hoja.autoSizeColumn(0);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(1);
			celda.setCellValue(detalles_producto.getCategoria());
			hoja.autoSizeColumn(1);
			celda.setCellStyle(estilo);
			
			
			/*
			 * celda = fila.createCell(1);
			 * celda.setCellValue(producto.getDetalles_producto()); hoja.autoSizeColumn(5);
			 * celda.setCellStyle(estilo);
			 */
			
		}
	}
	
	public void exportar(HttpServletResponse response) throws IOException {
		
		escribirCabeceraDeTabla();
		escribirDatosDeLaTabla();
		
		ServletOutputStream outputStream = response.getOutputStream();
		libro.write(outputStream);
		
		libro.close();
		outputStream.close();
		
	}

}
