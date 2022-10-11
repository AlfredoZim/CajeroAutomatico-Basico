import time
from datetime import datetime

movimientos = ".....:::   MOVIMIENTOS REGISTRADOS   :::.....\n"
saldo = 1000;
dateFormat = "%d %b %Y - %H:%M:%S"

limite = 0
pin = "1234";
acceso = False;
separador = "\n\n\n\n\n\n\n\n\n\n\n\n═══════════════════════════════════════════════════════════╣\n\n\n\n";

def getConsulta():
    global saldo, movimientos, separador
    movimientos += f"\n{datetime.now().strftime(dateFormat)}  Consulta de movimientos"
    return "Saldo actual: $"+"{:.2f}".format(saldo)

def getRetiro(retiro):
    global saldo, movimientos, dateFormat
    msj = f'''No se tienen fondos suficientes!
    Saldo: ${"{:.2f}".format(saldo)} 
    '''
    saldoAnterior = saldo
    if saldo != 0 and saldo > retiro:
        saldo-= retiro
        msj = f'\nUsted está retirando: ${"{:.2f}".format(retiro)}'
        movimientos += f'''\n{datetime.now().strftime(dateFormat)}  Retiro de efectivo: ${"{:.2f}".format(retiro)}
                        Saldo anterior: ${"{:.2f}".format(saldoAnterior)}
        '''
    return msj

def menu():
    global separador
    print(f'''{separador}
    Selecciona una opción del menú:
    1. Consultar saldo
    2. Retirar efectivo
    3. Consulta de movimientos
    4. Salir
    ''')
    opcion = int(input("Opción: "))
    return opcion

def salir():
    global separador
    print('''
    ¿Desea continuar al menú principal?
    1. Sí       2. No
    ''')
    opcion = int(input("Selección: "))
    if opcion == 2:
        print(f"{separador}Cerrando sesión...")
        time.sleep(2)
        exit()


def opciones():
    global movimientos, saldo
    while True:
        op = menu()
        if op == 1:
            print(f"{separador} {getConsulta()}")
            salir()
        elif op == 2:
            retiro = int(input(f"{separador}Monto a Retirar: $"))
            print(f"{getRetiro(retiro)}")
            salir()
        elif op == 3:
            print(f"{separador} {movimientos}")
            salir()
        elif op == 4:
            print(f"{separador}Cerrando sesión...")
            time.sleep(2)





print("..:: Bienvenido Usuario ::..")
pinIn = input("Por favor, ingrese su contraseña:")
while pinIn != pin:
    if limite == 2:
        print(f"{separador}Se ha llegado al límite de intentos")
        exit()
    print(f"{separador} Contraseña invalida, ingresela nuevamente")
    pinIn = input("Por favor, ingrese su contraseña:")
    limite+=1
opciones()