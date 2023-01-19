using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Moq;
using PetClinicService.Controllers;
using PetClinicService.Models;
using PetClinicService.Models.Requests.ClientRequests;
using PetClinicService.Services;
using PetClinicService.Services.Impl;


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

        // не удалось получить 1 в operationResult, тест не проходит по equal
        // не получилось получить подтверждение от "заглушки" что объект создавался.
        // дайте пожалуйста подсказку и я доделаю тесты.
        [Fact]
        public void CreateClientsTest() 
        {

            CreateClientRequest createClientRequest = new CreateClientRequest();

            createClientRequest.FirstName = "Test";
            createClientRequest.SurName = "Test";
            createClientRequest.Patronymic = "Test";
            createClientRequest.Document = "Test";
            createClientRequest.Birthday = DateTime.Now;

            _mockClientRepository.Setup(repository => repository.Create(new Client 
            { 
                FirstName = createClientRequest.FirstName,
                SurName = createClientRequest.SurName,
                Patronymic = createClientRequest.Patronymic,
                Document= createClientRequest.Document,
                Birthday = createClientRequest.Birthday
            }));


            ActionResult<int> operationResult = _clientController.Create(createClientRequest);

            int expectedOperationValue = 1;

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<Client>((OkObjectResult)operationResult.Result);
            Assert.Equal<int>(expectedOperationValue, (int)((OkObjectResult)operationResult.Result).Value);
        }



    }
}
