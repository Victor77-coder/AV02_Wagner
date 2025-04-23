from django.db import models

class Paciente(models.Model):
    nome = models.CharField(max_length=100)
    email = models.EmailField(unique=True)

class Consulta(models.Model):
    paciente = models.ForeignKey(Paciente, on_delete=models.CASCADE, related_name='consultas')
    data = models.DateTimeField()
    observacoes = models.TextField()

