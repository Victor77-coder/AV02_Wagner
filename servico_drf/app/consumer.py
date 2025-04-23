import pika
import json

def callback(ch, method, properties, body):
    dados = json.loads(body)
    print("Nova consulta recebida:", dados)

def start():
    connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
    channel = connection.channel()

    channel.queue_declare(queue='consultas')

    channel.basic_consume(queue='consultas',
                          on_message_callback=callback,
                          auto_ack=True)

    print(' [*] Esperando mensagens. Para sair pressione CTRL+C')
    channel.start_consuming()
