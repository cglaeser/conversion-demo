# build environment
FROM node:18.6.0-alpine as build
# set working directory
# this is the working folder in the container
# from which the app will be running from
WORKDIR /app
# copy everything to /app directory
# as opposed to on dev, in prod everything is copied to docker
COPY . /app
# add the node_modules folder to $PATH
ENV PATH /app/node_modules/.bin:$PATH
RUN npm install --silent
RUN npm install react-scripts@3.2.0 -g --silent
COPY . /app
RUN npm run build

# production environment
FROM nginx:1.17.5-alpine
COPY --from=build /app/build /usr/share/nginx/html
# if you are using react router 
# you need to overwrite the default nginx configurations
# remove default nginx configuration file
RUN rm /etc/nginx/conf.d/default.conf
COPY nginx/nginx.conf /etc/nginx/conf.d
# expose port 80 to the outer world
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]