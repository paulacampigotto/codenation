import requests
import json
import hashlib

def decifra(text, cases):
    l = list(text)
    l2 = ""
    y= ""
    for i in range(len(l)):
        if(l[i] != ' ' and l[i] != '.'):
            x = ord(l[i])-cases
            if(x < 97):
                y = 122 - (97 - x) + 1
                x = y
            l2 += chr(x)
        else:
            l2 += l[i]
    return l2

#request = requests.get('https://api.codenation.dev/v1/challenge/dev-ps/generate-data?token=7aef3030b2fe12bdb5f6000a00a09941f5c2ae3c')

#data = request.json()

#with open('answer.json', 'w+') as f:
#    json.dump(data, f, indent=2)

with open('answer.json') as file:
    data = json.load(file)

numero_casas = data['numero_casas']
token = data['token']
cifrado = data['cifrado']
data['decifrado'] = decifra(cifrado, int(numero_casas))
data['resumo_criptografico'] = hashlib.sha1(data['decifrado'].encode(encoding='UTF-8',errors='strict')).hexdigest()

with open('answer.json', 'w+') as file:
    json.dump(data, file, indent=2)

#with open('answer.json', 'rb') as f:
#    r = requests.post('https://api.codenation.dev/v1/challenge/dev-ps/submit-solution?token=7aef3030b2fe12bdb5f6000a00a09941f5c2ae3c', files={'answer': f}, data={'file':'answer'})

#print(r.text)
