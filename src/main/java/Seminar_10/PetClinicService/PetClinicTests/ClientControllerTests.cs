using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Moq;
using PetClinicService.Controllers;
using PetClinicService.Models;
using PetClinicService.Services;

namespace PetClinicTests
{
    public class ClientControllerTest
    {
        private ClientController _clientController;
        private Mock<IClientRepository> _mockClientRepository;

        public ClientControllerTest() 
        {
            _mockClientRepository = new Mock<IClientRepository>();
            _clientController = new ClientController(_mockClientRepository.Object);
        }

        [Fact]
        public void GetAllClientsTest()
        {
            // [1] Подготовка данных для тестирования
            _mockClientRepository.Setup(repository =>
            repository.GetAll()).Returns(new List<Client>()
            {
                new Client(),
                new Client(),
                new Client()
            });

            // [2] Вызов метода тестирования
            ActionResult<List<Client>> operationResult = _clientController.GetAll();

            // [3] Проверка результата тестирования
            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<List<Client>>(((OkObjectResult)operationResult.Result).Value);

            _mockClientRepository.Verify(repository => repository.GetAll(),Times.Once);
        }
    }
}
