from flask import Blueprint, request, render_template, redirect, url_for
from datetime import datetime
import requests

router = Blueprint('router', __name__)

@router.route('/')
def home():
    return render_template('index.html')

@router.route('/persona', methods=['GET'])
def persona():
    r = requests.get('http://localhost:8099/api/persona/all')
    data = r.json()
    return render_template('/personaUI/persona.html', lista=data["data"])

@router.route('/persona/<id>', methods=['GET'])
def get_persona(id):
    r = requests.get(f'http://localhost:8099/api/persona/get/{id}')
    data = r.json()
    
    return render_template('/personaUI/persona_id.html', data=data["data"])

@router.route('/persona/save', methods=['GET'])
def save_persona():
    return render_template('/personaUI/form_persona.html')



@router.route('/persona/save', methods=['POST'])
def post_form():
    fecha_nacimiento = request.form.get('fechaNacimiento')
    
    fecha_formateada = datetime.strptime(fecha_nacimiento, "%Y-%m-%d").strftime("%Y-%m-%d")
    
    data = {
        "nombre": request.form.get('nombre'),
        "apellido": request.form.get('apellido'),
        "dni": request.form.get('cedula'),  
        "fechaNacimiento": fecha_formateada, 
        "direccion": request.form.get('direccion')
    }
    
    response = requests.post("http://localhost:8099/api/persona/save", json=data)
    return redirect(url_for('router.persona'))

@router.route('/persona/<id>/delete', methods=['POST'])
def del_persona(id):
    r = requests.delete(f'http://localhost:8099/api/persona/delete/{id}')
    return redirect(url_for('router.persona'))
