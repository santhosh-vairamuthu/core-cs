import numpy as np

def encrypt(text: str, key: int) -> str:
    if not text:
        raise ValueError("Text is empty")
    if not isinstance(text, str):
        raise ValueError("Text should be a string")
    # convert text to ascii values
    ascii_matrix = np.array([ord(c) for c in text])
    # create key matrix
    key_matrix = np.random.randint(10, size=(len(text), len(text)))
    # check if determinant is non-zero
    while np.linalg.det(key_matrix) == 0:
        key_matrix = np.random.randint(10, size=(len(text), len(text)))
    # encrypt the message
    cipher_matrix = np.matmul(ascii_matrix, key_matrix)
    # convert the matrix to a string and return
    return '#' + ':'.join(map(str, cipher_matrix))

def decrypt(cipher: str, key: int) -> str:
    if not cipher:
        raise ValueError("Cipher is empty")
    if not isinstance(cipher, str):
        raise ValueError("Cipher should be a string")
    # extract the matrix values from the string
    cipher_matrix = np.array(list(map(int, cipher.split(':')[1:])))
    # calculate the inverse of the key matrix
    inv_key_matrix = np.linalg.inv(key_matrix)
    # decrypt the message
    ascii_matrix = np.matmul(cipher_matrix, inv_key_matrix)
    # convert the matrix to a string and return
    return ''.join(chr(int(x)) for x

t = str(input())
en=encrypt(text)
de=decrypt(en)
print(de)