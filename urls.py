from django.contrib import admin
from django.conf.urls import url
from .views import Modelview
from django.contrib.auth import views as auth_views
from . import views

#app_name = 'IBMS'

urlpatterns = [

    url(r'^$',Modelview.as_view(), name="IBMS"),
    url(r'^logout/', auth_views.LogoutView.as_view(template_name='logout.html'), name="logout"),
    url(r'viewothersrequest/', views.viewothersrequest, name="viewothersrequest"),
    url(r'managetrack/', views.managetrack, name="managetrack"),
    url(r'viewblooddonors/', views.viewblooddonors, name="viewblooddonors"),


]