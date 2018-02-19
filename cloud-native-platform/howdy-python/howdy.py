from flask import Flask
from flask import request

import random
import os
import sys

app = Flask(__name__)

# Get port from env variable or select default
port = int(os.getenv("PORT", 9000))

@app.route('/howdy')
def howdy():
    return "Howdy Python from index: " + str(os.getenv("CF_INSTANCE_INDEX", 0))

@app.route('/echo', methods=['POST'])
def echo():
    data = request.get_data()
    print "POST data " + data
    return data, 200

@app.route('/int')
def random_integer():
    min = request.args.get('min')
    max = request.args.get('max')
    if min == None:
        min = 0
    if max == None:
        max = sys.maxint
    print "min=" + str(min) + ", max=" + str(max)
    return str(random.randint(int(min), int(max))), 200

if __name__ == '__main__':
    app.run(host='0.0.0.0', port=port)
