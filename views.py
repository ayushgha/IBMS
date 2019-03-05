#from django.http import HttpResponse
import pyrebase
from django.shortcuts import render, HttpResponse
from .forms import HomeForm
from django.views.generic import TemplateView

config = {
  "apiKey": "AIzaSyCYxPlKBP6sdfvWNURaALJMU2spEhIOg5k",
  "authDomain": "doit-142a6.firebaseapp.com",
  "databaseURL": "https://doit-142a6.firebaseio.com",
  "storageBucket": "doit-142a6.appspot.com"
}

firebase = pyrebase.initialize_app(config)

db = firebase.database()



class Modelview(TemplateView):
    template_name = 'requestform.html'
    after_submit = 'viewothersrequest.html'

    def get(self,request):
        username = None
        if request.user.is_authenticated:
              username = request.user.username
              username = 'Hi '+username
        else:
             print(username)
        form = HomeForm()
        return render(request,self.template_name,{'form':form, 'username':username})

    def post(self,request):
        form = HomeForm(request.POST)
        print(form.is_valid())
        if form.is_valid():
            Blood_Group_Required = form.cleaned_data['Blood_Group_Required']
            Quantity = form.cleaned_data['Quantity']
            Delivery_to_Blood_Bank_number = form.cleaned_data['Delivery_to_Blood_Bank_number']

            print(Blood_Group_Required)
            data = {'Blood_Group_Required':Blood_Group_Required,'Quantity':Quantity,'Delivery_to_Blood_Bank_number':Delivery_to_Blood_Bank_number}
            db.child("Request").push(data)
            form = HomeForm()
        args = {'form':form,'Delivery_to_Blood_Bank_number':Delivery_to_Blood_Bank_number}

        return render(request,self.template_name,args)

        # def index(request):
#     return render(request,'home.html')
def viewothersrequest(request):
     return render(request,'viewothersrequest.html')


def managetrack(request):
    return render(request, 'managetrack.html')


def viewblooddonors(request):
    return render(request, 'viewblooddonors.html')
