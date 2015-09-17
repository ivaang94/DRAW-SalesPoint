/*
 * Copyright (C) 2015 Luis Chávez Bustamante
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package mx.uach.fing.draw.project.salespoint.filter;

import spark.Filter;
import spark.Request;
import spark.Response;

/**
 * Filtros para verificar la sesion del usuario.
 *
 * @author Luis Chávez Bustamante
 */
public class AdminFilter {

    public static final Logged LOGGED = new Logged();

    private AdminFilter() {
    }

    /**
     * Filtro para verificar que el usuario este logeado.
     */
    public static class Logged implements Filter {

        @Override
        public void handle(Request request, Response response) throws Exception {
            Object user = request.session().attribute("user");
            if (null == user) {
                response.redirect("/");
            }
        }
    }
}